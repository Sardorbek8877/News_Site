package uz.bek.app_news_site.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.bek.app_news_site.entity.Role;
import uz.bek.app_news_site.entity.User;
import uz.bek.app_news_site.entity.enums.Huquq;
import uz.bek.app_news_site.repository.RoleRepository;
import uz.bek.app_news_site.repository.UserRepository;
import uz.bek.app_news_site.utils.AppConstants;

import java.util.Arrays;

import static uz.bek.app_news_site.entity.enums.Huquq.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")){
            Huquq[] huquqs = Huquq.values();

            Role admin = roleRepository.save(new Role(
                    AppConstants.ADMIN,
                    Arrays.asList(huquqs),
                    "System admin"
            ));

            Role user = roleRepository.save(new Role(
                    AppConstants.USER,
                    Arrays.asList(ADD_COMMENT, EDIT_COMMENT, DELETE_MY_COMMENT),
                    "user"
            ));

            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true
            ));

            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true
            ));
        }
    }
}
