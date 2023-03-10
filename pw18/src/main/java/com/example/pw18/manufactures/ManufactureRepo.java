package com.example.pw18.manufactures;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ManufactureRepo extends JpaRepository<Manufacture, Long> {
}
