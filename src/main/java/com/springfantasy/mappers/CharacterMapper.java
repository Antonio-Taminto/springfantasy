package com.springfantasy.mappers;

import com.springfantasy.DTO.request.CharacterRequestDTO;
import com.springfantasy.DTO.request.CreateUserRequestDTO;
import com.springfantasy.DTO.response.CharacterResponseDTO;
import com.springfantasy.DTO.response.UserResponseDTO;
import com.springfantasy.entitites.CharacterEntity;
import com.springfantasy.entitites.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CharacterMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CharacterEntity convertCharacterRequestToEntity(CharacterRequestDTO request){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(request, CharacterEntity.class);
    }

    public CharacterResponseDTO convertCharacterEntityToResponse(CharacterEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(entity, CharacterResponseDTO.class);
    }
    public List<CharacterResponseDTO> mapList(List<CharacterEntity> source) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return source
                .stream()
                .map(element -> modelMapper.map(element, CharacterResponseDTO.class))
                .collect(Collectors.toList());
    }
}
