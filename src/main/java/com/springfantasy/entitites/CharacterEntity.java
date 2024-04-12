package com.springfantasy.entitites;

import com.springfantasy.entitites.enums.ClassEnum;
import com.springfantasy.entitites.enums.TypeEnum;

import jakarta.persistence.*;


@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "type")
    private TypeEnum typeEnum;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "class")
    private ClassEnum classEnum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public CharacterEntity(ClassEnum classEnum, Long id, String name, TypeEnum typeEnum, UserEntity userEntity) {
        this.classEnum = classEnum;
        this.id = id;
        this.name = name;
        this.typeEnum = typeEnum;
        this.userEntity = userEntity;
    }

    public CharacterEntity() {
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
