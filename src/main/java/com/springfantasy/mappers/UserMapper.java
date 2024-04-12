package com.springfantasy.mappers;

import com.springfantasy.DTO.request.CreateUserRequestDTO;
import com.springfantasy.DTO.response.UserResponseDTO;
import com.springfantasy.entitites.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserEntity convertUserRequestToEntity(CreateUserRequestDTO request){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(request, UserEntity.class);
    }

    public UserResponseDTO convertUserEntityToResponse(UserEntity entity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(entity, UserResponseDTO.class);
    }
    public List<UserResponseDTO> mapList(List<UserEntity> source) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return source
                .stream()
                .map(element -> modelMapper.map(element, UserResponseDTO.class))
                .collect(Collectors.toList());
    }
}
