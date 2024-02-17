package ru.ravvcheck.labweb4.result;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "hits")
@Data
@NoArgsConstructor
public class Hit {
    @Id
    @GeneratedValue
    private Long id;

    private Float x;
    private Float y;
    private Float r;
    private String isHit;
    private String time;
    private Long executionTime;
    private String owner;

    public Hit(Float x, Float y, Float r, String owner) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = String.valueOf(AreaCheck.isHit(x, y, r));
        this.time = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
        this.owner = owner;
    }

    public static boolean validateInput(float x, float y, float r) {
        if (x > 4 || x < -4) return false;
        if (y > 5 || y < -3) return false;
        return !(r > 4) && !(r < 0);
    }
}
