package Gr30234.HelloSpring.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String index() {
        return "index";
    }
}
