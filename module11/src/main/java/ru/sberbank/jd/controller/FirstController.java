package ru.sberbank.jd.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.controller.out.FirstOut;

import java.util.Map;

@RestController
//@RequestMapping("/out")
@Slf4j
public class FirstController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    // localhost:8080/url_path?param1=value1&param2=value2
    @GetMapping("/out")
    public FirstOut out() {
        return new FirstOut("1", "2", "3");
    }

    @GetMapping("/out/params")
    public FirstOut outParams(@RequestParam("param1") String param1,
            @RequestParam("param2") String param2,
            @RequestHeader("user-x") String headerUserX) {
        return new FirstOut(param1, param2, headerUserX);
    }

    @GetMapping("/out/params/all")
    public String outAllParams(@RequestParam Map<String, String> allParams) {
        return allParams.toString();
    }

    @GetMapping("/out/{id}")
    public String getId(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        log.info(request.getPathInfo());
        log.info(String.valueOf(response.getStatus()));
        return id;
    }


}
