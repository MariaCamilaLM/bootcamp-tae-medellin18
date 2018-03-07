package com.glb.bootcamp.tae.annotation;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class UserTest {

    @Test
    @User(id = 1, name = "Lionel Messi", email = "lionel.messi@gmail.com")
    public void myTest() throws NoSuchMethodException {
        Annotation[] annotations = this.getClass().getMethod("myTest").getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getCanonicalName());
        }

        User user = this.getClass().getMethod("myTest").getAnnotation(User.class);
        System.out.println(user.id());
        System.out.println(user.name());
        System.out.println(user.email());
        System.out.println(user.status());

        if ("INACTIVE".equals(user.status())) {
            // Do something with this...
        }

    }

    @Test
    public void myTest2() {
        try {
            Class clazz = Class.forName("java.lang.String");
            String myString = (String) clazz.getDeclaredConstructor(String.class).newInstance("1234");
            System.out.println(myString);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
