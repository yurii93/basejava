package com.java.webapp;

import com.java.webapp.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume();
        Class classObject = resume.getClass();
        Method toStringMethod = classObject.getMethod("toString", null);
        String returnedValue = (String) toStringMethod.invoke(resume);
        System.out.println(returnedValue);
    }
}
