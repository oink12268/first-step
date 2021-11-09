package com.eggplant.board.presentation.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequiredArgsConstructor
@AllArgsConstructor
//@ResponseBody
//@RequestMapping("board/")
public class BoardRestController {

    @GetMapping("/vue")
    public String vue() {

        return "index.html";
    }

//    @GetMapping("api/hello")
//    public String hello() {
//        return "hello";
//    }

}
