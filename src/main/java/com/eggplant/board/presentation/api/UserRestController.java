package com.eggplant.board.presentation.api;

import com.eggplant.board.application.admin.UserService;
import com.eggplant.board.domain.user.UserRepository;
import com.eggplant.board.domain.user.entity.User;
import com.eggplant.board.presentation.dto.UserDto;
import com.eggplant.board.presentation.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserRestController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public void signUpUser(@RequestBody UserDto userDto) throws Exception {
        userService.signUpUser(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findUserList() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
