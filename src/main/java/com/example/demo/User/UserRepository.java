package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//dostęp do bazy danych poprzez ten interfejs
@Repository
public interface UserRepository
    extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select u.id, u.name from User u where u.id = ?1")
    UserProfile findUserProfileById(int id);

    @Query("select u from User u where u.name = ?1")
    Optional<User> findUserByName(String username);

    @Query(value = "select u.id from User u where u.name = ?1", nativeQuery = true)
    Optional<UserId> findUserIdByName(String username);

    @Query("select u from User u where u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query(value = "select u.id from User u where u.email = ?1", nativeQuery = true)
    Optional<UserId> findUserIdByEmail(String email);


}
