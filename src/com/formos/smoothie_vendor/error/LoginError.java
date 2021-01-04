package com.formos.smoothie_vendor.error;

public class LoginError extends RuntimeException {
    public LoginError() {
        super("Invalid username or password");
    }
}
