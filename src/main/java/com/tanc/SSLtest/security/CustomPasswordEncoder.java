package com.tanc.SSLtest.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return PasswordHelper.encryptPassword(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodePassword) {
        return PasswordHelper.checkPassword(charSequence.toString(),encodePassword);
    }
}
