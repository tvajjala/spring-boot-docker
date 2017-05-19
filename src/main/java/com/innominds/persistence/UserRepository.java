package com.innominds.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innominds.persistence.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName( String name );

}
