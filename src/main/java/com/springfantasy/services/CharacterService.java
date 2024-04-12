package com.springfantasy.services;

import com.springfantasy.DTO.request.CharacterRequestDTO;
import com.springfantasy.DTO.response.CharacterResponseDTO;
import com.springfantasy.entitites.CharacterEntity;
import com.springfantasy.entitites.UserEntity;
import com.springfantasy.mappers.CharacterMapper;
import com.springfantasy.repositories.CharacterRepository;
import com.springfantasy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CharacterMapper characterMapper;

    public Optional<CharacterResponseDTO> createCharacter(CharacterRequestDTO request,Long userId){
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if(userEntityOptional.isPresent()){
            CharacterEntity characterEntity = characterMapper.convertCharacterRequestToEntity(request);
            characterEntity.setUserEntity(userEntityOptional.get());
            CharacterEntity savedCharacter = characterRepository.save(characterEntity);
            return Optional.of(characterMapper.convertCharacterEntityToResponse(savedCharacter));
        }else {
            return Optional.empty();
        }
    }
    public List<CharacterResponseDTO> getCharacterList(){
        return characterMapper.mapList(characterRepository.findAll());
    }
    public Optional<CharacterResponseDTO> getCharacterFromId(Long id){
        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(id);
        if(characterEntityOptional.isPresent()){
            return Optional.of(characterMapper.convertCharacterEntityToResponse(characterEntityOptional.get()));
        }else {
            return Optional.empty();
        }
    }
    public Optional<CharacterResponseDTO> updateCharacterFromId(Long id,CharacterRequestDTO request){
        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(id);
        if(characterEntityOptional.isPresent()){
            characterEntityOptional.get().setName(request.getName());
            characterEntityOptional.get().setTypeEnum(request.getTypeEnum());
            characterEntityOptional.get().setClassEnum(request.getClassEnum());
            CharacterEntity savedCharacter = characterRepository.save(characterEntityOptional.get());
            CharacterResponseDTO response = characterMapper.convertCharacterEntityToResponse(savedCharacter);
            return Optional.of(response);
        }else {
            return Optional.empty();
        }
    }
    public Optional<CharacterResponseDTO> deleteCharacterFromId(Long id){
        Optional<CharacterEntity> characterEntityOptional = characterRepository.findById(id);
        if(characterEntityOptional.isPresent()){
            characterRepository.deleteById(characterEntityOptional.get().getId());
            return Optional.of(characterMapper.convertCharacterEntityToResponse(characterEntityOptional.get()));
        }else {
            return Optional.empty();
        }
    }
}
