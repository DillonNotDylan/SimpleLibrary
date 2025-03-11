package com.lirbraryapp.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lirbraryapp.backend.repository.UserRepository;
import com.lirbraryapp.backend.dataTransferObjects.UserRequest;
import com.lirbraryapp.backend.dataTransferObjects.AccountInfo;
import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
import com.lirbraryapp.backend.dataTransferObjects.StatusRequest;
import com.lirbraryapp.backend.utils.AccountUtils;
import com.lirbraryapp.backend.entity.User;

@Service
public class UserServicesImpl implements UserServices{


    /**
     * Using Autowired to to inject dependencies 
     */
    @Autowired
    UserRepository userRepository;

    @Override
    public LibraryResponse createAccount(UserRequest userRequest) {
        /**
         * Check if user exists first
         */
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return LibraryResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                .accountInfo(null)
                .build();
        }

        /**
         * Creating an account
         */
        User newUser = User.builder()
            .firstName(userRequest.getFirstName())
            .lastName(userRequest.getLastName())
            .gender(userRequest.getGender())
            .state(userRequest.getState())
            // .uid(AccountUtils.generateAccountNumber())
            .email(userRequest.getEmail())
            .isActive(0)
            .build();


        /**
         * Saving a new user into the database by using 'save' method from JpaRepository
         * We can use this because the userRepository interface extends JpaRepository
         */
        User savedUser = userRepository.save(newUser);

        /**
         * Reponse that is given to the user after making an API request
         */
        return LibraryResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_CREATION_CODE)
            .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
            .accountInfo(AccountInfo.builder()
                .name(savedUser.getFirstName() + " " + savedUser.getLastName())
                .email(savedUser.getEmail())
                .uid(savedUser.getUid())
                .is_active(savedUser.getIsActive())
                .build()
            )   
            .build();
    }

    @Override
    public LibraryResponse accountAuthorized(StatusRequest userRequest) {

        /**
         * Check if provided account number exists
         */
        boolean exists = userRepository.existsByEmail(userRequest.getEmail());
        if (!exists) {
            return LibraryResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
                .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
                .accountInfo(null)
                .build();
        }

        User foundUser = userRepository.findByEmail(userRequest.getEmail());

        if(foundUser.getIsActive() == 0) {
            return LibraryResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_NOT_AUTHORIZED_CODE)
                .responseMessage(AccountUtils.ACCOUNT_NOT_AUTHORIZED_MESSAGE)
                .accountInfo(AccountInfo.builder()
                    .name(foundUser.getFirstName() + " " + foundUser.getLastName())
                    .email(foundUser.getEmail())
                    .uid(foundUser.getUid())
                    .is_active(foundUser.getIsActive())
                    .build()
                )
                .build();
        }

        else {
            return LibraryResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_AUTHORIZED_CODE)
                .responseMessage(AccountUtils.ACCOUNT_AUTHORIZED_MESSAGE)
                .accountInfo(AccountInfo.builder()
                    .name(foundUser.getFirstName() + " " + foundUser.getLastName())
                    .email(foundUser.getEmail())
                    .uid(foundUser.getUid())
                    .is_active(foundUser.getIsActive())
                    .build()
                )
                .build();
        }
    }
    
    // @Override
    // public LibraryResponse rentBook(UserRequest userRequest) {

    //     User foundUser = userRepository.findByEmail(userRequest.getEmail());

    //     return LibraryResponse.builder()
    //         .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
    //         .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
    //         .accountInfo(AccountInfo.builder()
    //             .name(foundUser.getFirstName() + " " + foundUser.getLastName())
    //             .email(foundUser.getEmail())
    //             .uid(foundUser.getUid())
    //             .is_active(foundUser.getIsActive())
    //             .build()
    //         )
    //         .build();

    // }
    
    // @Override
    // public LibraryResponse returnBook(UserRequest userRequest) {

    //     User foundUser = userRepository.findByEmail(userRequest.getEmail());

    //     return LibraryResponse.builder()
    //         .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
    //         .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
    //         .accountInfo(AccountInfo.builder()
    //             .name(foundUser.getFirstName() + " " + foundUser.getLastName())
    //             .email(foundUser.getEmail())
    //             .uid(foundUser.getUid())
    //             .is_active(foundUser.getIsActive())
    //             .build()
    //         )
    //         .build();

    // }
    
    @Override
    public LibraryResponse booksInPossession(UserRequest userRequest) {

        User foundUser = userRepository.findByEmail(userRequest.getEmail());

        return LibraryResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
            .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
            .accountInfo(AccountInfo.builder()
                .name(foundUser.getFirstName() + " " + foundUser.getLastName())
                .email(foundUser.getEmail())
                .uid(foundUser.getUid())
                .is_active(foundUser.getIsActive())
                .build()
            )
            .build();

    }

}
