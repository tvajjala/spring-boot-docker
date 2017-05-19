package com.innominds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.innominds.persistence.AddressRepository;
import com.innominds.persistence.UserRepository;
import com.innominds.persistence.model.UserEntity;
import com.innominds.service.UserService;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    public static void main( String[] args ) {
        SpringApplication.run( SpringDemoApplication.class, args );

        System.out.println( "####################################################" );
        System.out.println( "############### DOCKER COMMANDS #################" );
        System.out.println( "####################################################" );
        System.out.println( "$/>docker images  ==> return all the images" );
        System.out.println( "$/>docker ps -a   ==> return all running containers" );
        System.out.println( "$/>docker build -t spring-boot .    ==> build image with Dockerfile" );
        System.out.println( "$/>mvn clean package docker;build ==> build docker image with maven plugin" );
        System.out.println( "$/>docker run -d -P --name=springBoot spring-boot" );
        System.out.println( "$/>docker port springBoot" );
        System.out.println( "$/>docker stop containerId/name  ==>stop container" );
        System.out.println( "$/>docker rm containerId/name ==> remove container" );
        System.out.println( "$/>docker rmi imageId/name ==>  deletes images " );
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserService userService;

    @Override
    public void run( String... args ) throws Exception {

        final UserEntity userEntity = new UserEntity( "Thiru" );
        // SAVING TRANSIENT INSTANCE WITH SINGLE QUERY ?
        // userEntity.getAddresses().add( addressRepository.save( new AddressEntity( "Hyderabad", userEntity ) ) );
        // userEntity.getAddresses().add( addressRepository.save( new AddressEntity( "Miyapur", userEntity ) ) );
        userRepository.save( userEntity );

        // final UserService userService = new UserServiceImpl();
        // System.out.println( userService.getUser( "Thiru" ) );

        userService.saveUser( new UserEntity( "thiru" ) );

    }

}
