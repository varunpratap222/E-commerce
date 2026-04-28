package com.example.EcommerceProject.service.impl;
import com.example.EcommerceProject.Security.JwtUtil;
import com.example.EcommerceProject.entity.User;
import com.example.EcommerceProject.repository.UserRepository;
import com.example.EcommerceProject.service.UserService;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }

    @Service
    public static class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final BCryptPasswordEncoder passwordEncoder;
        private final JwtUtil jwtUtil;

        public UserServiceImpl(UserRepository userRepository,
                               BCryptPasswordEncoder passwordEncoder,
                               JwtUtil jwtUtil) {

            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.jwtUtil = jwtUtil;
        }


        @Override
        public String register(User user) {

            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new RuntimeException("Email already registered");
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            return "User registered successfully";
        }

        @Override
        public String login(User user) {
            System.out.println("➡️ LOGIN SERVICE HIT: email=" + user.getEmail());

            User existingUser = userRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> {
                        System.out.println("❌ User not found");
                        return new RuntimeException("User not found");
                    });

            boolean matches = passwordEncoder.matches(user.getPassword(), existingUser.getPassword());
            System.out.println("➡️ Password matches? " + matches);

            if (!matches) {
                throw new RuntimeException("Invalid credentials");
            }

            String token = jwtUtil.generateToken(existingUser.getEmail());
            System.out.println("✅ Generated token: " + token);
            return token;
        }
    }
}
