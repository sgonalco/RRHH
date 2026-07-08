package com.example.rrhh.dto;

public class RoleDto {

    private Integer id;
    private String title;
    // no incluir listado de users para no crear relación cíclica

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
