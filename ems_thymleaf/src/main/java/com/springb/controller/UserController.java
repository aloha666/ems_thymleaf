package com.springb.controller;

import com.springb.entity.User;
import com.springb.service.UserService;
import com.springb.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //user register
    @PostMapping("/register")
    public String register(User user, String code, HttpSession session){

        String sessioncode = (String) session.getAttribute("code");
//        System.out.println(code);
//        System.out.println(sessioncode);
        if(sessioncode.equalsIgnoreCase(code)){
            userService.register(user);
            return "redirect:/index";
        }else{
            return "redirect:/toRegister";
        }

    }

    //generate code image
    @GetMapping("/code")
    private void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //generate code
        String securitycode = ValidateImageCodeUtils.getSecurityCode();
        //generate code
        BufferedImage image = ValidateImageCodeUtils.createImage(securitycode);
        //set code into seesion
        session.setAttribute("code", securitycode);
        //use response to output image
        ServletOutputStream os = response.getOutputStream();
        //use ImageIO utility class to output
        ImageIO.write(image,"png",os);

    }

    //user login
    @PostMapping("/login")
    private String login(String username, String password, HttpSession session){
        User login = userService.login(username,password);
        //System.out.println(login.getUsername());
        if(login != null) {
            session.setAttribute("user",login);
            return "redirect:/emp/findAll";
        }else{
            return "redirect:/index";
        }
    }


}
