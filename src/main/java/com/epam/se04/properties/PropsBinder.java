package com.epam.se04.properties;

import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.function.Function;

import static com.epam.se04.InputStreamUtils.withFileInputStream;

public interface PropsBinder {

    @NotNull
    static <T> T from(@NotNull Class<T> tClass) {
        String name = tClass.getSimpleName();
        return from(name.substring(0, 1).toLowerCase() + name.substring(1), tClass);
    }

    @NotNull
    static <T> T from(String fileName, Class<T> tClass) {
        val properties = new Properties();
        withFileInputStream(fileName + ".properties", properties::load);
        return from(properties::getProperty, tClass);
    }

    @NotNull
    static <T> T from(Function<String, String> getProperty, Class<T> tClass) {
        return from(getProperty, getMaxParamsCountConstructor(tClass));
    }

    @NotNull
    @SneakyThrows
    static <T> T from(Function<String, String> getProperty, @NotNull Constructor<T> constructor) {
        List<Object> list = new ArrayList<>();
        for (Parameter parameter : constructor.getParameters())
            list.add(resolveParameter(getProperty, parameter));
        return constructor.newInstance(
                list.toArray()
//                Arrays.stream(constructor.getParameters())
//                        .map(parameter -> resolveParameter(getProperty, parameter))
//                        .toArray()
        );
    }

    @NotNull
    @SneakyThrows
    private static <T> Constructor<T> getMaxParamsCountConstructor(@NotNull Class<T> propsClass) {
        //noinspection unchecked
//        return (Constructor<T>) Arrays.stream(propsClass.getConstructors())
//                .max(Comparator.comparingInt(Constructor::getParameterCount))
//                .orElseThrow(() -> new PropsBinderException("There is no any constructor!"));
        boolean seen = false;
        Constructor<?> best = null;
        Comparator<Constructor<?>> comparator = Comparator.comparingInt(Constructor::getParameterCount);
        for (Constructor<?> constructor : propsClass.getConstructors()) {
            if (!seen || comparator.compare(constructor, best) > 0) {
                seen = true;
                best = constructor;
            }
        }
        return (Constructor<T>) (seen ? Optional.<Constructor<?>>of(best) : Optional.<Constructor<?>>empty())
                .orElseThrow(() -> new PropsBinderException("There is no any constructor!"));
    }

    private static Object resolveParameter(@NotNull Function<String, String> getValue,
                                           @NotNull Parameter parameter) {
        String name = parameter.getName();
        String value = getValue.apply(name);
        Class<?> type = parameter.getType();

        if (type == String.class)
            return value;
        if (type == int.class || type == Integer.class)
            return Integer.parseInt(value);
        if (type == double.class || type == Double.class)
            return Double.parseDouble(value);
        if (type == long.class || type == Long.class)
            return Long.parseLong(value);
        if (type == boolean.class || type == Boolean.class)
            return Boolean.parseBoolean(value);
        if (type == char.class || type == Character.class)
            return value.charAt(0);
        if (type == float.class || type == Float.class)
            return Float.parseFloat(value);
        if (type == short.class || type == Short.class)
            return Short.parseShort(value);
        if (type == byte.class || type == Byte.class)
            return Byte.parseByte(value);

        String prefix = name + ".";
        return from(propertyName -> getValue.apply(prefix + propertyName), type);
    }
}
