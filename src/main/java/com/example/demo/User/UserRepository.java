package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//dostęp do bazy danych poprzez ten interfejs
@Repository
public interface UserRepository
    extends JpaRepository<User, Integer> {
    @Query("select u.id, u.name from User u where u.id = ?1")
    UserProfile findUserProfileById(int id);

    @Query("select u from User u where u.name = ?1")
    Optional<User> findUserByName(String username);
}
