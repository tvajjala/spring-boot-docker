package com.innominds.persistence.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "address" )
public class AddressEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "user_id" )
    UserEntity user;

    public AddressEntity() {
    }

    public AddressEntity( String name, UserEntity user ) {
        super();
        this.name = name;
        this.user = user;
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
