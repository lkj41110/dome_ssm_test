package com.lk.orm.dao.model;

import java.io.Serializable;

/**
 * 获取表的属性
 * @author luokai
 */
public class TableColumn implements Serializable {

    private String field;
    private String type;
    private String key;
    /**
     * 默认值
     */
    private String Default;
    /**
     * 是否为空
     */
    private String Null;
    private String extra;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefault() {
        return Default;
    }

    public void setDefault(String aDefault) {
        Default = aDefault;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getNull() {
        return Null;
    }

    public void setNull(String aNull) {
        Null = aNull;
    }

    @Override
    public String toString() {
        return "TableColumn{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", Default='" + Default + '\'' +
                ", Null='" + Null + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
