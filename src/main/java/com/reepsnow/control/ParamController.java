package com.reepsnow.control;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("/classPath") 这种用法也是允许的
public class ParamController {

	@RequestMapping("/index")
    public String index() {
        return "Index Page";
    }

    @RequestMapping("/")/*该方法使用跟springMVC一样，也可以放到Application类上面*/
    public String greeting() {
        return "Hello World!";
    }
    @RequestMapping("/users/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }

    @RequestMapping("/posts/{id}")
    public String post(@PathVariable("id") int id) {
        return String.format("post %d", id);
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "Login Page";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost() {
        return "Login Post Request";
    }
}
