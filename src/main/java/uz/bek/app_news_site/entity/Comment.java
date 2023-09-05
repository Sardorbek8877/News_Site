package uz.bek.app_news_site.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.app_news_site.entity.template.AbstractEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Comment extends AbstractEntity {

    @Column(nullable = false, columnDefinition = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
