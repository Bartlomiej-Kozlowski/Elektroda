package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//dostęp do bazy danych poprzez ten interfejs
@Repository
public interface UserRepository
    extends JpaRepository<User, Integer> {

}
