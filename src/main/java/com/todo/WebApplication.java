package com.todo;

import com.coreoz.plume.jersey.guice.JerseyGuiceFeature;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.todo.guice.ApplicationModule;
import com.todo.jersey.GrizzlySetup;
import org.glassfish.grizzly.GrizzlyFuture;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.h2.tools.Server;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * The application entry point, where it all begins.
 */
public class WebApplication {

    // maximal waiting time for the last process to execute after the JVM received a kill signal
    public static final Duration GRACEFUL_SHUTDOWN_TIMEOUT = Duration.ofSeconds(60);

    public static void main(String[] args) {
        try {
            Server.createTcpServer("-tcpPort", "9092").start();
            long startTimestamp = System.currentTimeMillis();

            // initialize all application objects with Guice
            Injector injector = Guice.createInjector(Stage.PRODUCTION, new ApplicationModule());

            ResourceConfig jerseyResourceConfig = injector.getInstance(ResourceConfig.class);
            // enable Jersey to create objects through Guice Injector instance
            jerseyResourceConfig.register(new JerseyGuiceFeature(injector));
            // starts the server
            HttpServer httpServer = GrizzlySetup.start(
                    jerseyResourceConfig,
                    System.getProperty("http.port"),
                    System.getProperty("http.address")
            );

            // Add a shutdown hook to execute some code when the JVM receive a kill signal before it stops
            addShutDownListener(httpServer);
            // If Plume Scheduler / Wisp is used, uncomment next line
            // addShutDownListerner(httpServer, injector.getInstance(Scheduler.class));

            System.out.println("Server started in {} ms" + (System.currentTimeMillis() - startTimestamp));
        } catch (Throwable e) {
            System.out.println("Failed to start server" + e);
            // This line is important, because during initialization some libraries change the main thread type
            // to daemon, which mean that even if the project is completely down, the JVM is not stopped.
            // Stopping the JVM is important to enable production supervision tools to detect and restart the project.
            System.exit(1);
        }
    }

    private static void addShutDownListener(HttpServer httpServer) { // If scheduler is used, add arg: Scheduler scheduler
        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
                    System.out.println("Stopping signal received, shutting down server and scheduler...");
                    GrizzlyFuture<HttpServer> grizzlyServerShutdownFuture = httpServer.shutdown(GRACEFUL_SHUTDOWN_TIMEOUT.toSeconds(), TimeUnit.SECONDS);
                    try {
                        System.out.println("Waiting for server to shut down... Shutdown timeout is {} seconds" + GRACEFUL_SHUTDOWN_TIMEOUT.toSeconds());
                        // If scheduler is used, uncomment next line
                        // scheduler.gracefullyShutdown(GRACEFUL_SHUTDOWN_TIMEOUT);
                        grizzlyServerShutdownFuture.get();
                    } catch (Exception e) {
                        System.out.println("Error while shutting down server." + e);
                    }
                },
                "shutdownHook"
        ));
    }
}
