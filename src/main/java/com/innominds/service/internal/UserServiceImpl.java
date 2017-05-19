package com.innominds.service.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innominds.persistence.UserRepository;
import com.innominds.persistence.model.UserEntity;
import com.innominds.service.UserService;

@Transactional( )
@Service( "userService" )
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity getUser( String name ) {

        final UserEntity userEntity = userRepository.findByName( name );
        userEntity.setName( "thiru" );
        return userEntity;
    }

    @Override
    public UserEntity saveUser( UserEntity userEntity ) {

        userEntity = userRepository.save( userEntity );
        userEntity.setName( "NEWNAME" );
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
