package com.tanc.SSLtest.security;

import com.tanc.SSLtest.Repository.AccountRepository;
import com.tanc.SSLtest.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetialsSevice implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetialsSevice.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("Load UserDetails by username: " + username);

        Account account = accountRepository.findByUsername(username);
        System.out.println(account.getPassword());

        if (account == null)
            throw new UsernameNotFoundException(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : account.getPermission().split(" ")) {
            if (permission.isEmpty()) continue;
            authorities.add(new SimpleGrantedAuthority(permission));
        }

        return new CustomUser(username, account.getPassword(),
                true, true, true,
                account.isVertified(), authorities);
    }
}
