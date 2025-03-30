package com.example.andersenhomework.cusrom_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {
    private String folder = "external";

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass == null) {
            try {
                loadedClass = super.loadClass(name, false);
            } catch (ClassNotFoundException e) {
                loadedClass = load(name);
            }
        }
        return loadedClass;
    }

    public Class<?> load(String name) {
        String filePath = folder + File.separator + name + ".class";
        byte[] binaryClassData;
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            binaryClassData = fileInputStream.readAllBytes();
            return defineClass(name, binaryClassData, 0, binaryClassData.length);
        } catch (IOException e) {
            System.err.println("Cant find from file: " + filePath);
        }
        return null;
    }
}
