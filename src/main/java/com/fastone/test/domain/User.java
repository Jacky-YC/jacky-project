package com.fastone.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "t_user")
public class User extends BaseDomain {

    private static final long serialVersionUID = 6685580900983126696L;

    private String username;

    private Integer age;

}
