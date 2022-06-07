package com.haier.openplatform.wms.util;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.List;

public class MyAnnotation {

    public static <T> List<ValidateResult> validate(T t){
        List<ValidateResult> validateResults = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value==null || value == "") {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    ValidateResult validateResult = new ValidateResult();
                    validateResult.setMessage(notNull.fileName()+"不能为空");
                    validateResults.add(validateResult);
                }
            }

        }
        return validateResults;
    }
}
