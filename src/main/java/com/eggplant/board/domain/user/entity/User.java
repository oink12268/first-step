package com.eggplant.board.domain.user.entity;

import com.eggplant.board.presentation.dto.UserDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String email;

    @Column( length = 50, nullable = false)
    private String userName;

    @Column( length = 50, nullable = false)
    private String password;

    public User() {}

    public User(UserDto userDto) {
        this.email = userDto.getEmail();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
    }

    public static User createUser(UserDto userDto) {
        return new User(userDto);
    }

}
