package uz.bek.app_news_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.app_news_site.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
