package uz.bek.app_news_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bek.app_news_site.entity.User;
import uz.bek.app_news_site.payload.ApiResponse;
import uz.bek.app_news_site.payload.RegisterDto;
import uz.bek.app_news_site.repository.RoleRepository;
import uz.bek.app_news_site.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository repository;

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername()))
            return new ApiResponse("Username already registered", false);
        User user = new User(
//                registerDto.getFullName(),
//                registerDto.getUsername(),
//                null,

        );

        return null;
    }
}
