package com.lirbraryapp.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lirbraryapp.backend.repository.UserRepository;
import com.lirbraryapp.backend.dataTransferObjects.UserRequest;
import com.lirbraryapp.backend.dataTransferObjects.AccountInfo;
import com.lirbraryapp.backend.dataTransferObjects.LibraryResponse;
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
         * Sending user an email about the successful creation of thier account
         */
        // EmailDetails emailDetails = EmailDetails.builder()
        //     .recipient(savedUser.getEmail())
        //     .subject("ACCOUNT CREATION")
        //     .messageBody("Congradulations! Your account has successfully been created!\nYour account details:\n"+ 
        //             "Account User: " + savedUser.getFirstName() + " " + savedUser.getLastName() + "\n" + 
        //             "Account Number: " + savedUser.getAccountNumber())
        //     .build();
        // emailService.sendEmailAlert(emailDetails);

        /**
         * Reponse that is given to the user after making an API request
         */
        return LibraryResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_CREATION_CODE)
            .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
            .accountInfo(AccountInfo.builder()
                // .accountBalance(savedUser.getAccountBalance())
                // .accountNumber(savedUser.getAccountNumber())
                // .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
                .build()
            )   
            .build();
    }

    @Override
    public LibraryResponse accountAuthorized(UserRequest userRequest) {

        /**
         * Check if provided account number exists
         */
        // boolean exists = userRepository.existsByAccountNumber(userRequest.getAccountNumber());
        // if (!exists) {
        //     return BankResponse.builder()
        //         .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
        //         .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
        //         .accountInfo(null)
        //         .build();
        // }

        User foundUser = userRepository.findByEmail(userRequest.getEmail());

        return LibraryResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
            .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
            .accountInfo(AccountInfo.builder()
            .activeStatus(foundUser.getIsActive())
            // .accountName(foundUser.getFirstName() + " " + foundUser.getLastName())
                .build())
            .build();

    }
    
    @Override
    public LibraryResponse rentBook(UserRequest userRequest) {

        User foundUser = userRepository.findByEmail(userRequest.getEmail());

        return LibraryResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
            .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
            .accountInfo(AccountInfo.builder()
            .activeStatus(foundUser.getIsActive())
            // .accountName(foundUser.getFirstName() + " " + foundUser.getLastName())
                .build())
            .build();

    }
    
    @Override
    public LibraryResponse returnBook(UserRequest userRequest) {

        User foundUser = userRepository.findByEmail(userRequest.getEmail());

        return LibraryResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
            .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
            .accountInfo(AccountInfo.builder()
            .activeStatus(foundUser.getIsActive())
            // .accountName(foundUser.getFirstName() + " " + foundUser.getLastName())
                .build())
            .build();

    }

}
