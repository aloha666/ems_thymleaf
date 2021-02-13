package com.springb.controller;

import com.springb.entity.Emp;
import com.springb.entity.User;
import com.springb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;
    //add emp
    @PostMapping("/save")
    public String register(Emp emp, String birthdate){
       // String dateString = (String) session.getAttribute("birthdate");
        System.out.println(birthdate);
        try{
            Date empbir = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
            emp.setBir(empbir);
        }catch(Exception e){
            System.out.println("Not Parable");
        }
        empService.save(emp);
        return "redirect:/emp/findAll";


    }
    //return all
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Emp> emps =empService.findAll();
        model.addAttribute("emps",emps);
        //System.out.println(emps);
        return "ems/emplist";
    }

    //return all
    @PostMapping("/update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emp/findAll";
    }

}
