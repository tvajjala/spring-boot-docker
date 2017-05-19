package com.innominds.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innominds.persistence.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
