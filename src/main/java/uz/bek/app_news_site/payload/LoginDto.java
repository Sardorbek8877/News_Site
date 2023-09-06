package uz.bek.app_news_site.payload;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull(message = "Username must be not empty")
    private String username;

    @NotNull(message = "Password be not empty")
    private String password;
}
