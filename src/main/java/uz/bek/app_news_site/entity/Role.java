package uz.bek.app_news_site.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.app_news_site.entity.enums.Huquq;
import uz.bek.app_news_site.entity.template.AbstractEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Role extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Huquq> huquqList;

//    @Enumerated(value = EnumType.STRING)
//    private RoleType roleType;
}
