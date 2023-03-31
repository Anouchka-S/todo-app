package com.todo.db.dao;

import com.coreoz.plume.db.querydsl.crud.CrudDaoQuerydsl;
import com.coreoz.plume.db.querydsl.transaction.TransactionManagerQuerydsl;
import com.todo.db.generated.QTodo;
import com.todo.db.generated.Todo;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TodoDao extends CrudDaoQuerydsl<Todo> {

    @Inject
    public TodoDao(TransactionManagerQuerydsl transactionManagerQuerydsl) {
        super(transactionManagerQuerydsl, QTodo.todo);
    }

    // READ
    public List<Todo> getTodo() {
        return transactionManager
                .selectQuery()
                .select(QTodo.todo)
                .from(QTodo.todo)
                .fetch();
    }

    // CREATE
    public Todo addTodo(Todo todo) {
        return save(todo);
    }

    // UPDATE
    public long updateTodo(Long id, byte newValue) {
        return transactionManager
                .update(QTodo.todo)
                .set(QTodo.todo.checkTODO, newValue)
                .where(QTodo.todo.id.eq(id))
                .execute();
    }

    // DELETE
    public long deleteTodo(Long id) {
        return delete(id);
    }
}
