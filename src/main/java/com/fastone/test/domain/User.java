package com.fastone.test.domain;

import com.fasterxml.jackson.annotation.JsonView;
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

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView {};

    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    private String password;

}
