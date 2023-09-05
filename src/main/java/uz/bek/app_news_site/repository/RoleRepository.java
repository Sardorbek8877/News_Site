package uz.bek.app_news_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.app_news_site.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
