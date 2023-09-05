package uz.bek.app_news_site.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import uz.bek.app_news_site.entity.enums.Huquq;
import uz.bek.app_news_site.entity.enums.RoleType;
import uz.bek.app_news_site.entity.template.AbstractEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Role extends AbstractEntity {

    private String name;

    @ElementCollection
    private List<Huquq> huquqList;

//    @Enumerated(value = EnumType.STRING)
//    private RoleType roleType;
}
