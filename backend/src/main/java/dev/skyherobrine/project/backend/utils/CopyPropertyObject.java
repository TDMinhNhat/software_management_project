package dev.skyherobrine.project.backend.utils;

import org.springframework.beans.BeanUtils;

public class CopyPropertyObject {
    public static Object copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
