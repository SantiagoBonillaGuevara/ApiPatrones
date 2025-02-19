package com.example.demo4;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class service {

    private final repository repository;

    public service(repository repository) {
        this.repository = repository;
    }
    // Guardar nombre en el archivo
    public void saveName(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        repository.save(userEntity);
    }

    // Obtener todos los nombres guardados
    public List<String> getAllNames() {
        List<UserEntity> users = repository.findAll();
        return users.stream()
                .map(UserEntity::getName)
                .toList();
    }
}