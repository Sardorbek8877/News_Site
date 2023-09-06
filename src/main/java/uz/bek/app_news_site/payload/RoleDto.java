package uz.bek.app_news_site.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.bek.app_news_site.entity.Role;
import uz.bek.app_news_site.entity.enums.Huquq;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotBlank
    private String name;

    private String description;

    @NotEmpty
    private List<Huquq> roleList;
}
