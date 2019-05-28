package com.tanc.SSLtest.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.User;


public class NullAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    public NullAuthenticationToken(User principal) {
        super(principal.getAuthorities());
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
