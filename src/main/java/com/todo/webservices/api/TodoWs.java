package com.todo.webservices.api;


import com.coreoz.plume.jersey.security.permission.PublicApi;
import com.todo.db.generated.Todo;
import com.todo.services.todo.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todo")
@Tag(name = "Todo", description = "Manage Todo web-services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PublicApi
@Singleton

public class TodoWs {
    private final TodoService todoService;

    @Inject
    public TodoWs(TodoService todoService) {
        this.todoService = todoService;
    }

    // READ
    @GET
    @Operation(description = "retrieve all todo")
    public List<Todo> fetchTdo() {
        return this.todoService.getTodo();
    }

    // CREATE
    @POST
    @Path("/add")
    @Operation(description = "add a todo")
    public Todo createTodo(@RequestBody Todo newTodo) {

        return this.todoService.addTodo(newTodo);
    }


    // UPDATE
    @PATCH
    @Path("/{id}/check")
    @Operation(description = "update a todo")
    public boolean checkTodo(@PathParam("id") Long id) {
        return this.todoService.toggleCheckTodo(id, 1);
    }

    @PATCH
    @Path("/{id}/unCheck")
    @Operation(description = "update a todo")
    public boolean updateTodo(@PathParam("id") Long id) {
        return this.todoService.toggleCheckTodo(id, 0);
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    @Operation(description = "delete a todo")
    public long deleteTodo(@PathParam("id") Long id) {
        return this.todoService.deleteTodo(id);
    }
}

