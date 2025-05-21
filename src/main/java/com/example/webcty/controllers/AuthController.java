package com.example.webcty.controllers;

import com.example.webcty.config.security.JwtUtil;
import com.example.webcty.dto.request.MemberRequest;
import com.example.webcty.dto.response.MemberResponse;
import com.example.webcty.entities.Member;
import com.example.webcty.enums.MemberRole;
import com.example.webcty.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberRequest memberRequest) {
        if (memberService.findByUsername(memberRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        memberRequest.setPassword(passwordEncoder.encode(memberRequest.getPassword()));

        MemberResponse newMember = memberService.createMember(memberRequest);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberRequest memberRequest) {
        Member member = memberService.findByUsername(memberRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(memberRequest.getPassword(), member.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        String token = jwtUtil.generateToken(member.getUsername(), member.getRole().name());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("role", member.getRole().name());
        response.put("username", member.getUsername());

        return ResponseEntity.ok(response);
    }
}
