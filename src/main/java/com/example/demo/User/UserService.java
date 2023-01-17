package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

//tutaj API do obsługi urzytkowników
@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }
    public UserProfile getUserProfile(UserProfileRequestDTO userProfile){
        return this.userRepository.findUserProfileById(userProfile.id());
    }

    public User addUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(UserRole.ROLE_USER);

        this.userRepository.save(user);

        return user;
    }
//    public User addUser2(UserAddRequestDTO user){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.password());
//        User newUser = new User(
//                user.username(), user.email(), encodedPassword, com.example.demo.UserRoleEnum.ROLE_USER
//        );
//        return this.userRepository.save(newUser);
//    }

//    public User save(UserAddRequestDTO user) {
//        return userRepository.save(
//            new User(
//                user.username(),
//                user.email(),
//                passwordEncoder.encode(user.password()),
//                UserRole.ROLE_USER
//            )
//        );
//    }
}
