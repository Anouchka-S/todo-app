package com.todo.db.generated;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.processing.Generated;
import com.querydsl.sql.Column;

/**
 * Todo is a Querydsl bean type
 */
@Generated("com.coreoz.plume.db.querydsl.generation.IdBeanSerializer")
public class Todo extends com.coreoz.plume.db.querydsl.crud.CrudEntityQuerydsl {

    @Column("checkTODO")
    private Byte checkTODO;

    @Column("id")
    @JsonSerialize(using=com.fasterxml.jackson.databind.ser.std.ToStringSerializer.class)
    private Long id;

    @Column("titleTODO")
    private String titleTODO;

    @Column("typeTODO")
    private String typeTODO;

    public Byte getCheckTODO() {
        return checkTODO;
    }

    public void setCheckTODO(Byte checkTODO) {
        this.checkTODO = checkTODO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleTODO() {
        return titleTODO;
    }

    public void setTitleTODO(String titleTODO) {
        this.titleTODO = titleTODO;
    }

    public String getTypeTODO() {
        return typeTODO;
    }

    public void setTypeTODO(String typeTODO) {
        this.typeTODO = typeTODO;
    }

    @Override
    public String toString() {
        return "Todo#" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (id == null) {
            return super.equals(o);
        }
        if (!(o instanceof Todo)) {
            return false;
        }
        Todo obj = (Todo) o;
        return id.equals(obj.id);
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }
        final int prime = 31;
        int result = 1;
        result = prime * result + id.hashCode();
        return result;
    }

}

