package com.company.bookstore.enumeration;

public enum StatusType {
    STATUS_DISABLED, STATUS_ENABLED, STATUS_DELETED;

    public static StatusType getById(Integer status) {
        if(status == null) return null;
        if(status == 0) return STATUS_DISABLED;
        if(status == 1) return STATUS_ENABLED;
        if(status == 2) return STATUS_DELETED;
        return null;
    }

}
