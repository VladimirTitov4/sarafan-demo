package ru.titov.sarafandemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.titov.sarafandemo.domain.User;
import ru.titov.sarafandemo.repo.MessageRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final MessageRepo messageRepo;

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("messages", messageRepo.findAll());
        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
