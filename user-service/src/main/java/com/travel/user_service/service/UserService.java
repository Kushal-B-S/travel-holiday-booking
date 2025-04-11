package com.travel.user_service.service;

import com.travel.user_service.dto.LoginRequest;
import com.travel.user_service.dto.RegisterRequest;
import com.travel.user_service.entity.User;
import com.travel.user_service.repository.UserRepository;
import com.travel.user_service.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request) {
        Optional<User> existing = userRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            return "❌ User already exists!";
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .email(request.getEmail())
                .password(hashedPassword)
                .fullName(request.getFullName())
                .build();

        userRepository.save(user);
        return "✅ User registered successfully!";
    }



    public String login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                // Generate JWT token
                String token = jwtService.generateToken(user.getEmail());
                return "Login successful. Token: " + token;
            } else {
                return "❌ Invalid password!";
            }
        }
        return "❌ User not found!";
    }


    public String forgotPassword(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return "❌ No user found with this email!";
        }

        // Simulate sending OTP or reset link
        return "📧 Password reset link sent to email (simulated).";
    }

    public String resetPassword(String email, String newPassword) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return "❌ Invalid email.";
        }

        User user = userOpt.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        return "✅ Password has been reset successfully!";
    }

}
