package com.innominds.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "user" )
public class UserEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    @OneToMany( mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    List<AddressEntity> addresses = new ArrayList<>();

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses( List<AddressEntity> addresses ) {
        this.addresses = addresses;
    }

    public UserEntity() {
    }

    public UserEntity( String name ) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}
