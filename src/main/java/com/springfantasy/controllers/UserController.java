package com.springfantasy.controllers;

import com.springfantasy.DTO.request.CreateUserRequestDTO;
import com.springfantasy.DTO.request.UpdateUserRequestDTO;
import com.springfantasy.DTO.response.UserResponseDTO;
import com.springfantasy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserRequestDTO request){
        return ResponseEntity.ok(userService.createUser(request));
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUserList(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable(name = "id") Long id){
        Optional<UserResponseDTO> responseDTOOptional = userService.getUserById(id);
        if(responseDTOOptional.isPresent()){
            return ResponseEntity.ok(responseDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable(name = "id") Long id, @RequestBody UpdateUserRequestDTO requestDTO){
        Optional<UserResponseDTO> responseDTOOptional = userService.updateUserById(id,requestDTO);
        if(responseDTOOptional.isPresent()){
            return ResponseEntity.ok(responseDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/password/{id}")
    public ResponseEntity<UserResponseDTO> updateUserPasswordById(@PathVariable(name = "id") Long id, @RequestParam String password){
        Optional<UserResponseDTO> responseDTOOptional = userService.updateUserPasswordById(id,password);
        if(responseDTOOptional.isPresent()){
            return ResponseEntity.ok(responseDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDTO> deleteUserById(@PathVariable(name = "id") Long id){
        Optional<UserResponseDTO> responseDTOOptional = userService.deleteUserById(id);
        if(responseDTOOptional.isPresent()){
            return ResponseEntity.ok(responseDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
