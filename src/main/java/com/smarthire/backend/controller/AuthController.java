package com.smarthire.backend.controller;

import com.smarthire.backend.dto.LoginRequest;
import com.smarthire.backend.entity.User;
import com.smarthire.backend.repository.UserRepository;
import com.smarthire.backend.service.JwtService;
import com.smarthire.backend.service.OpenAIService;
import com.smarthire.backend.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OpenAIService openAIService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/test")
    public String test() {
        return "Backend Working";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if(user != null &&
                user.getPassword().equals(request.getPassword())) {

            return jwtService.generateToken(user.getEmail());
        }

        return "Invalid Credentials";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {

        String text = resumeService.extractText(file);

        return openAIService.extractSkills(text);
    }
    @PostMapping("/voice")
    public String uploadVoice(
            @RequestParam("file")
            MultipartFile file) {

        return file.getOriginalFilename();
    }
}