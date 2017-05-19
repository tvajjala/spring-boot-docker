package com.innominds.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innominds.persistence.model.AddressEntity;
import com.innominds.persistence.model.UserEntity;
import com.innominds.service.UserService;

@RestController
@RequestMapping( "/users" )
public class UserResource {

    @Autowired
    UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger( UserResource.class );

    @RequestMapping( value = "/{name}", method = RequestMethod.GET )
    public UserEntity getUser( @PathVariable String name ) {

        LOG.info( "Returning user with name {} ", name );
        final UserEntity user = userService.getUser( name );

        for ( final AddressEntity address : user.getAddresses() ) {

            System.out.println( "Address : " + address.getName() );
        }

        return user;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<UserEntity> getUsers() {

        return userService.getAllUsers();
    }

}
