package com.example.pw18.authentication.cookies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepo extends JpaRepository<CookieEntity, Long> {
}
