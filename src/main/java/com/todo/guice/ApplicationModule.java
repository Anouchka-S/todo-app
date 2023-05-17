package com.todo.guice;

import com.coreoz.plume.conf.guice.GuiceConfModule;
import com.coreoz.plume.db.guice.DataSourceModule;
import com.coreoz.plume.jersey.guice.GuiceJacksonModule;
import com.google.inject.AbstractModule;
import com.todo.jersey.JerseyConfigProvider;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Group the Guice modules to install in the application
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new GuiceConfModule());
        install(new GuiceJacksonModule());
        install(new DataSourceModule());
        // database & Querydsl installation
        //install(new GuiceQuerydslModule());

        // prepare Jersey configuration
        bind(ResourceConfig.class).toProvider(JerseyConfigProvider.class);
    }

}
