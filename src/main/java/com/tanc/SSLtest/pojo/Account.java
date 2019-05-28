package com.tanc.SSLtest.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Setter
@Getter
@ToString
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String username;
    private String password;
    private String permission;
    private boolean vertified;

}
