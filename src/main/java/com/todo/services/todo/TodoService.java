package com.todo.services.todo;

import com.todo.db.dao.TodoDao;
import com.todo.db.generated.Todo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TodoService {
    private final TodoDao todoDao;

    @Inject
    public TodoService(TodoDao todoDao) { this.todoDao = todoDao; }

    // READ
    public List<Todo> getTodo() {
        return this.todoDao.getTodo();
    }

    // CREATE
    public Todo addTodo(Todo newTodo) {
        Todo todoToaDD = new Todo();
        todoToaDD.setTypeTODO(newTodo.getTypeTODO());
        todoToaDD.setTitleTODO(newTodo.getTitleTODO());
        todoToaDD.setCheckTODO((byte) 0);
        return this.todoDao.addTodo(todoToaDD);
    }

    // UPDATE
    public boolean toggleCheckTodo(Long id, int newValue) {
        return this.todoDao.updateTodo(id, (byte) newValue) == 1;
    }

    // DELETE
    public long deleteTodo(Long id) {
        return this.todoDao.deleteTodo(id);
    }
}
