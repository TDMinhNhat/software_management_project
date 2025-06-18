package dev.skyherobrine.project.backend.utils;

import java.util.Arrays;
import java.util.Base64;

public class EncodeDecodeUtil {

    public static String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public static String decode(String input) {
        return Arrays.toString(Base64.getDecoder().decode(input));
    }
}
