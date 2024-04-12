package com.springfantasy.DTO.response;

import com.springfantasy.entitites.CharacterEntity;

import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<CharacterResponseDTO> characterResponseDTOList;

    public UserResponseDTO(
            List<CharacterResponseDTO> characterResponseDTOList,
            String email, Long id, String name) {
        this.characterResponseDTOList = characterResponseDTOList;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public UserResponseDTO() {
    }

    public List<CharacterResponseDTO> getCharacterResponseDTOList() {
        return characterResponseDTOList;
    }

    public void setCharacterResponseDTOList(List<CharacterResponseDTO> characterResponseDTOList) {
        this.characterResponseDTOList = characterResponseDTOList;
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
}
