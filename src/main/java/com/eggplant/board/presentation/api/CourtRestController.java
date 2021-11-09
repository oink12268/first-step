package com.eggplant.board.presentation.api;

import com.eggplant.board.application.admin.UserService;
import com.eggplant.board.domain.court.CourtRepository;
import com.eggplant.board.domain.court.entity.Court;
import com.eggplant.board.domain.user.UserRepository;
import com.eggplant.board.domain.user.entity.User;
import com.eggplant.board.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequiredArgsConstructor
@ResponseBody
public class CourtRestController {

    private final UserService userService;
    private final CourtRepository courtRepository;

//    @PostMapping("/signup")
//    public void signUpUser(@RequestBody UserDto userDto) throws Exception {
//        userService.signUpUser(userDto);
//    }

    @GetMapping("/courts")
    public ResponseEntity<List<Court>> findCourtList() {
        return ResponseEntity.ok().body(courtRepository.findAll());
    }
}
