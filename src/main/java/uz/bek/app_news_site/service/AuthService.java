package uz.bek.app_news_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bek.app_news_site.entity.User;
import uz.bek.app_news_site.exceptions.ResourceNotFoundException;
import uz.bek.app_news_site.payload.ApiResponse;
import uz.bek.app_news_site.payload.RegisterDto;
import uz.bek.app_news_site.repository.RoleRepository;
import uz.bek.app_news_site.repository.UserRepository;
import uz.bek.app_news_site.utils.AppConstants;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(RegisterDto registerDto) {

        if (!registerDto.getPassword().equals(registerDto.getPrePassword()))
            return new ApiResponse("Passwords are not same!", false);

        if (userRepository.existsByUsername(registerDto.getUsername()))
            return new ApiResponse("Username already registered", false);
        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                roleRepository.findByName(AppConstants.USER).orElseThrow(() -> new ResourceNotFoundException("Role", "name", AppConstants.USER)),
                true);
        userRepository.save(user);
        return new ApiResponse("User has successfully registered", true);
    }

    public UserDetails loadUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
