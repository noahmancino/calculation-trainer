package model.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.List;

@Document("Users")
@Data
public class User {
    @Id
    private String id;
    @Size(max=20)
    @Indexed(unique = true)
    @NotBlank
    private String username;
    @Size(max=30)
    @NotBlank
    private String password;
    private List<Game> games;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
