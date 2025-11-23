package com.reusexpress.controller;
import com.reusexpress.model.User; import com.reusexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/auth")
public class AuthController {
    @Autowired private UserService userService;
    @GetMapping("/login") public String loginPage() { return "login"; }
    @GetMapping("/register") public String registerPage() { return "register"; }
    @PostMapping("/register") public String register(@ModelAttribute User user, Model model) {
        if(userService.findByUsername(user.getUsername()) != null) { model.addAttribute("error", "Username already exists"); return "register"; }
        userService.register(user);
        model.addAttribute("message", "Registered successfully. Please login.");
        return "login";
    }
    @PostMapping("/login") public String login(@RequestParam String username, @RequestParam String password, Model model, javax.servlet.http.HttpSession session) {
        User u = userService.findByUsername(username);
        if(u == null || !u.getPassword().equals(password)) { model.addAttribute("error", "Invalid credentials"); return "login"; }
        session.setAttribute("user", u);
        return "redirect:/";
    }
}
