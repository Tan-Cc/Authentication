package com.tanc.SSLtest.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@ToString
@Getter @Setter
public class Users {

    @Id
    private Long id;

    private String username;
    private String password;
}
