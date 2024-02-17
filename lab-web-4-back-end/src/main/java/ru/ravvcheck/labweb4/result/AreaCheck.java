package ru.ravvcheck.labweb4.result;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component

public final class AreaCheck {
    private static final double X_MIN = -4;
    private static final double X_MAX = 4;
    private static final double Y_MIN = -5;
    private static final double Y_MAX = 3;
    private static final double R_MIN = -4;
    private static final double R_MAX = 4;

    public static boolean isHit(Float x, Float y, Float r) {
        if (x > X_MAX || x < X_MIN) {
            return false;
        }
        if (y > Y_MAX || y < Y_MIN) {
            return false;
        }
        if (r > R_MAX || r < R_MIN) {
            return false;
        }
        return isCircle(x, y, r) || isRectangle(x, y, r) || isTriangle(x, y, r);
    }

    private static boolean isRectangle(Float x, Float y, Float r) {
        return x <= 0 && y >= 0 && x >= -r && y <= r / 2;
    }

    private static boolean isCircle(Float x, Float y, Float r) {
        return x * x + y * y <= r * r && x >= 0 && y <= 0;
    }

    private static boolean isTriangle(Float x, Float y, Float r) {
        return x <= 0 && y <= 0 && y >= -x - r;
    }
}
