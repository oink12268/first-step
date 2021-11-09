package com.eggplant.board.application.admin;

import com.eggplant.board.domain.user.UserRepository;
import com.eggplant.board.domain.user.entity.User;
import com.eggplant.board.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUpUser(UserDto userDto) throws  Exception {
        userRepository.save(User.createUser(userDto));
    }
}
