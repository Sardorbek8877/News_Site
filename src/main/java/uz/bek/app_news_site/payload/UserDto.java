package uz.bek.app_news_site.payload;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(message = "Full name must be not empty")
    private String fullName;

    @NotNull(message = "Username must be not empty")
    private String username;

    @NotNull(message = "Password must be not empty")
    private String password;

    @NotNull(message = "Role must be not empty")
    private Integer roleId;
}
