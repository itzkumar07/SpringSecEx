package com.bootcoding.SpringSecEx;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(11, "Sachin",35),
            new Student(12, "Ramesh",95),
            new Student(13, "Shiva",45)
    ));

    @GetMapping("/_csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/Students")
    public List<Student> getStudents(){
        return students;
    }
}
