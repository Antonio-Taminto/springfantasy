package com.springfantasy.DTO.response;

import com.springfantasy.entitites.enums.ClassEnum;
import com.springfantasy.entitites.enums.TypeEnum;

public class CharacterResponseDTO {
    private Long id;

    private String name;

    private TypeEnum typeEnum;

    private ClassEnum classEnum;

    public CharacterResponseDTO(ClassEnum classEnum, Long id, String name, TypeEnum typeEnum) {
        this.classEnum = classEnum;
        this.id = id;
        this.name = name;
        this.typeEnum = typeEnum;
    }

    public CharacterResponseDTO() {
    }

    public ClassEnum getClassEnum() {
        return classEnum;
    }

    public void setClassEnum(ClassEnum classEnum) {
        this.classEnum = classEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }
}
