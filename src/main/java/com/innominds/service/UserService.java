package com.innominds.service;

import java.util.List;

import com.innominds.persistence.model.UserEntity;

public interface UserService {

    public UserEntity getUser( String name );

    public UserEntity saveUser( UserEntity userEntity );

    public List<UserEntity> getAllUsers();

}
