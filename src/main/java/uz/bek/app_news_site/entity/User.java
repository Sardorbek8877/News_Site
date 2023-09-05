package uz.bek.app_news_site.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.bek.app_news_site.entity.enums.Huquq;
import uz.bek.app_news_site.entity.template.AbstractEntity;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
public class User extends AbstractEntity implements UserDetails {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Role role;

    private boolean enabled;
    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Huquq> huquqList = this.role.getHuquqList();
        Set<GrantedAuthority> grantedAuthorityList = new HashSet<>();
        for (Huquq huquq : huquqList){
            grantedAuthorityList.add(new SimpleGrantedAuthority(huquq.name()));
        }
//        for (Huquq huquq : huquqList){
//            grantedAuthorityList.add(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return huquq.name();
//                }
//            });
//        }
        return grantedAuthorityList;
    }

    public User(String fullName, String username, String password, Role role, boolean enabled) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
}
