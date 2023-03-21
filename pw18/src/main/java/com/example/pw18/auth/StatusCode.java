package com.example.pw18.auth;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class StatusCode {
    private int code;

    public static StatusCode create(int code) {
        return new StatusCode(code);
    }
}
