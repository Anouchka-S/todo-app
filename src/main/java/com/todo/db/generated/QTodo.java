package com.todo.db.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTodo is a Querydsl query type for Todo
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTodo extends com.querydsl.sql.RelationalPathBase<Todo> {

    private static final long serialVersionUID = -1413838790;

    public static final QTodo todo = new QTodo("tda_TODO");

    public final NumberPath<Byte> checkTODO = createNumber("checkTODO", Byte.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath titleTODO = createString("titleTODO");

    public final StringPath typeTODO = createString("typeTODO");

    public final com.querydsl.sql.PrimaryKey<Todo> primary = createPrimaryKey(id);

    public QTodo(String variable) {
        super(Todo.class, forVariable(variable), "null", "tda_TODO");
        addMetadata();
    }

    public QTodo(String variable, String schema, String table) {
        super(Todo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTodo(String variable, String schema) {
        super(Todo.class, forVariable(variable), schema, "tda_TODO");
        addMetadata();
    }

    public QTodo(Path<? extends Todo> path) {
        super(path.getType(), path.getMetadata(), "null", "tda_TODO");
        addMetadata();
    }

    public QTodo(PathMetadata metadata) {
        super(Todo.class, metadata, "null", "tda_TODO");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(checkTODO, ColumnMetadata.named("checkTODO").withIndex(4).ofType(Types.TINYINT).withSize(3).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(titleTODO, ColumnMetadata.named("titleTODO").withIndex(2).ofType(Types.VARCHAR).withSize(45).notNull());
        addMetadata(typeTODO, ColumnMetadata.named("typeTODO").withIndex(3).ofType(Types.VARCHAR).withSize(45));
    }

}

