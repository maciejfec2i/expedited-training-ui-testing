package com.saucedemo.utils;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassReader {

    /**
     * Method for retrieving a map of classes discovered within the provided package and its sub-packages.<br><br>
     *
     * The key is the simple name of the class and the value is the full class path.<br>
     * Example:
     * <ul>
     *     <li>key = SimpleClassName, value = com.example.some.package.SimpleClassName</li>
     * </ul>
     * <br>
     *
     * NOTE: If the classes within the provided package and its sub-packages are not all unique,
     * it will cause a duplicate key error.
     *
     * @param aPackage The {@link Package} in which classes are to be discovered.
     * @return A {@link Map} of discovered classes.
     */
    public static Map<String, String> getClassMapFrom(Package aPackage) {
        try {
            return ClassPath
                    .from(Thread.currentThread().getContextClassLoader())
                    .getTopLevelClassesRecursive(aPackage.getName())
                    .stream()
                    .collect(Collectors.toMap(ClassPath.ClassInfo::getSimpleName, ClassPath.ClassInfo::getName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
