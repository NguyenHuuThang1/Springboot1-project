package com.bookStore.repository;

import com.bookStore.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
        public AppUser findByEmail(String email);
}
