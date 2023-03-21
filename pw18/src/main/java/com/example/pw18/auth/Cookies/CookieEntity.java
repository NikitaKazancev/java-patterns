package com.example.pw18.auth.Cookies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cookies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CookieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String value;
}
