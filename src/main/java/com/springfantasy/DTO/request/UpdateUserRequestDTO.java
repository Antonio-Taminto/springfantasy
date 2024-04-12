package com.springfantasy.DTO.request;

public class UpdateUserRequestDTO {
    private String name;
    private String email;

    public UpdateUserRequestDTO(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UpdateUserRequestDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
