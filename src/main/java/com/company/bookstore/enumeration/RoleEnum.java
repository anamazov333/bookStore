package com.company.bookstore.enumeration;

public enum RoleEnum {
    ROLE_USER(1),
    ROLE_PUBLISHER(2);

    public Integer id;


    RoleEnum(Integer id) {
        this.id = id;
    }



    public static RoleEnum getById(Integer roleId) {
        if(roleId == null) return null;
        if(roleId == 1) return ROLE_USER;
        if(roleId == 2) return ROLE_PUBLISHER;

        return null;
    }
}
