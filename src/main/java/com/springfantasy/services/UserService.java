package com.springfantasy.services;

import com.springfantasy.DTO.request.CreateUserRequestDTO;
import com.springfantasy.DTO.request.UpdateUserRequestDTO;
import com.springfantasy.DTO.response.UserResponseDTO;
import com.springfantasy.entitites.UserEntity;
import com.springfantasy.mappers.UserMapper;
import com.springfantasy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO createUser(CreateUserRequestDTO request){
        return userMapper.convertUserEntityToResponse(
                userRepository.save(
                        userMapper.convertUserRequestToEntity(request)
                )
        );
    }

    public List<UserResponseDTO> getAllUser(){
        return userMapper.mapList(userRepository.findAll());
    }

    public Optional<UserResponseDTO> getUserById(Long id){
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()){
            return Optional.of(userMapper.convertUserEntityToResponse(userEntityOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public Optional<UserResponseDTO> updateUserById(Long id, UpdateUserRequestDTO request){
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()){
            userEntityOptional.get().setName(request.getName());
            userEntityOptional.get().setEmail(request.getEmail());
            UserEntity updatedUserEntity = userRepository.save(userEntityOptional.get());
            UserResponseDTO response = userMapper.convertUserEntityToResponse(updatedUserEntity);
            return Optional.of(response);
        }else {
            return Optional.empty();
        }
    }
    public Optional<UserResponseDTO> updateUserPasswordById(Long id, String password){
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()){
            userEntityOptional.get().setPassword(password);
            UserEntity updatedUserEntity = userRepository.save(userEntityOptional.get());
            UserResponseDTO response = userMapper.convertUserEntityToResponse(updatedUserEntity);
            return Optional.of(response);
        }else {
            return Optional.empty();
        }
    }
    public Optional<UserResponseDTO> deleteUserById(Long id){
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()){
            userRepository.delete(userEntityOptional.get());
            return Optional.of(userMapper.convertUserEntityToResponse(userEntityOptional.get()));
        }else {
            return Optional.empty();
        }
    }
}
