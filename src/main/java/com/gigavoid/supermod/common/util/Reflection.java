package com.gigavoid.supermod.common.util;

import net.minecraft.block.Block;

import java.lang.reflect.Field;

public class Reflection {
    public static Object getFieldValue(String fieldName, Class clazz, Object instance) {
        Field field = getField(clazz, fieldName);
        field.setAccessible(true);

        try {
            return field.get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean setFieldValue(String fieldName, Class clazz, Object value) {
        Field field = getField(clazz, fieldName);
        field.setAccessible(true);

        try {
            field.set(value, value);
        } catch (IllegalAccessException e){
            return false;
        }
        return true;
    }

    private static Field getField(Class clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            if (superClass == null) {
                e.printStackTrace();
            } else {
                return getField(superClass, fieldName);
            }
        }

        return null;
    }
}

