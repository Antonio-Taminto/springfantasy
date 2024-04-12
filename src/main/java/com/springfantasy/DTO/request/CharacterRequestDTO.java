package com.springfantasy.DTO.request;

import com.springfantasy.entitites.enums.ClassEnum;
import com.springfantasy.entitites.enums.TypeEnum;

public class CharacterRequestDTO {
    private String name;

    private TypeEnum typeEnum;

    private ClassEnum classEnum;

    public CharacterRequestDTO(ClassEnum classEnum, String name, TypeEnum typeEnum) {
        this.classEnum = classEnum;
        this.name = name;
        this.typeEnum = typeEnum;
    }

    public CharacterRequestDTO() {
    }

    public ClassEnum getClassEnum() {
        return classEnum;
    }

    public void setClassEnum(ClassEnum classEnum) {
        this.classEnum = classEnum;
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
