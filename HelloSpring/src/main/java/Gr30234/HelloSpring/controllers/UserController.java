package Gr30234.HelloSpring.controllers;

import Gr30234.HelloSpring.data.UserRepository;
import Gr30234.HelloSpring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

   /* @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepository userRepository;*/

    @Autowired
    private UserRepository userRepository;

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("events/index")
    public String getEvents() {
        return "/events/index";
    }

    @GetMapping("registration")
    public String registration(Model model) {
        model.addAttribute(new User());

        return "registration";
    }

    @GetMapping("account/create")
    public String displayCreateClient(Model model) {
        model.addAttribute("title", "Create Account");
        model.addAttribute(new User());
        return "account/create";
    }

    @PostMapping("account/create")
    public String processCreateClient(@ModelAttribute @Valid User user, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Account");
            return "account/create";
        }


        userRepository.save(user);
        return "redirect:../events/index";
    }


    @GetMapping("account/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Accounts");
        model.addAttribute("users", userRepository.findAll());
        return "account/delete";
    }

    @PostMapping("account/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] accountIds) {
        if (accountIds != null) {
            for (int id : accountIds) {
                userRepository.deleteById(id);
            }
        }

        return "redirect:../events/index";
    }

    @PostMapping("registration")
    public String registration(@ModelAttribute @Valid User userForm, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Account");
            return "account/create";
        }
        userRepository.save(userForm);
        return "redirect:../events/index";
    }

    /*@GetMapping("login")
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Username and password invalid.");
        }
        if(logout != null) {
            model.addAttribute("message", "Logged out successfully!");
        }

        return "login/login";
    }*/
}
