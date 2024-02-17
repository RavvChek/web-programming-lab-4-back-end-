package ru.ravvcheck.labweb4.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    @Column
    private String login;

    @NotNull
    @NotBlank
    @Column
    private String password;

    @NotNull
    @NotBlank
    private String salt;

    public User(String login, String password, String salt) {
        this.login = login;
        this.password = password;
        this.salt = salt;
    }
}
