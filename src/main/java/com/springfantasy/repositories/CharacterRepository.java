package com.springfantasy.repositories;

import com.springfantasy.entitites.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {
    List<CharacterEntity> findByName(String name);
    @Query("SELECT c FROM CharacterEntity c WHERE typeEnum = ?1")
    List<CharacterEntity> findByType(String typeEnum);
    @Query("SELECT c FROM CharacterEntity c WHERE classEnum = ?1")
    List<CharacterEntity> findByClass(String classEnum);
}
