package com.springfantasy.entitites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<CharacterEntity> characterEntityList = new ArrayList<>();

    public UserEntity(String password, String name, Long id, String email, List<CharacterEntity> characterEntityList) {
        this.password = password;
        this.name = name;
        this.id = id;
        this.email = email;
        this.characterEntityList = characterEntityList;
    }

    public UserEntity() {
    }

    public List<CharacterEntity> getCharacterEntityList() {
        return characterEntityList;
    }

    public void setCharacterEntityList(List<CharacterEntity> characterEntityList) {
        this.characterEntityList = characterEntityList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
