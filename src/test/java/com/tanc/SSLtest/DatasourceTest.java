package com.tanc.SSLtest;

import com.tanc.SSLtest.Repository.AccountRepository;
import com.tanc.SSLtest.Repository.UsersRepository;
import com.tanc.SSLtest.pojo.Account;
import com.tanc.SSLtest.pojo.Users;
import com.tanc.SSLtest.security.PasswordHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Test
    public void passwordEncode() {

        Account account = new Account();
        account.setId(101);
        account.setPassword("123456");
        account.setUsername("tanc");
        account.setPermission("ROLE_USER");
        account.setVertified(true);

        accountRepository.save(account);


//        String s = PasswordHelper.encryptPassword("123456");
//        System.out.println(s);
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("123456");
//        System.out.println(encode);

//        MyUserDetialsSevice myUserDetialsSevice = new MyUserDetialsSevice();
//        UserDetails tanc = myUserDetialsSevice.loadUserByUsername("tanc");
//        System.out.println(tanc);

//        System.out.println(usersRepository);
//        System.out.println(accountRepository);
//
//        List<Users> all = usersRepository.findAll();
//        for (Users u : all) {
//            System.out.println(u.getUsername());
//        }

//        //Account tanc = accountRepository.findByUsername("tanc");
//        Account one = accountRepository.getOne("101");
//        System.out.println(one.getPassword());
//        //System.out.println(tanc.getPassword());
    }

    @Test
    public void getAccount() {
        Account tanc = accountRepository.findByUsername("tanc");
        System.out.println(tanc.getPassword());
    }
}
