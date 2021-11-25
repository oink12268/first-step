package com.eggplant.board.domain.user.entity;

import com.eggplant.board.domain.common.Common;
import com.eggplant.board.domain.values.enumType.UserRole;
import com.eggplant.board.presentation.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
//public class User extends Common implements Serializable {
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 50, nullable = false)
    private String email;

    @Column( length = 50, nullable = false)
    private String userName;

    @Column( length = 50, nullable = false)
    private String pw;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;


    @Setter
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isEnable = true;                        // 사용 여부

    public User() {}

    public User(UserDto userDto) {
        this.email = userDto.getEmail();
        this.userName = userDto.getUserName();
        this.pw = userDto.getPassword();
    }

    public static User createUser(UserDto userDto) {
        return new User(userDto);
    }

}
