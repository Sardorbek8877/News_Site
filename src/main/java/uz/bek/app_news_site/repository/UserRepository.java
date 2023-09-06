package uz.bek.app_news_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.app_news_site.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
