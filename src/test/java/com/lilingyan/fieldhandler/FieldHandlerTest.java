package com.lilingyan.fieldhandler;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilingyan
 * @date 2019/11/24 下午10:34
 */
public class FieldHandlerTest {

    @Test
    public void in(){
        Dog dog = new Dog("我是狗1");
        Dog dog2 = new Dog("我是狗2");
        Dog dog3 = new Dog("我是狗3");
        Dog dog4 = new Dog("我是狗4");
        Dog dog5 = new Dog("我是狗5");
        Map<String,Dog> dogMap = new HashMap<>();
        dogMap.put(dog4.getName(),dog4);
        dogMap.put(dog5.getName(),dog5);
        Person person = new Person(null,dog, null,Arrays.asList(dog2,dog3),dogMap,null);

        FieldHandler.inProcess(person);
        System.out.println(person);
    }

    @Test
    public void out(){
        Dog dog = new Dog("我是狗1");
        Dog dog2 = new Dog("我是狗2");
        Dog dog3 = new Dog("我是狗3");
        Dog dog4 = new Dog("我是狗4");
        Dog dog5 = new Dog("我是狗5");
        Map<String,Dog> dogMap = new HashMap<>();
        dogMap.put(dog4.getName(),dog4);
        dogMap.put(dog5.getName(),dog5);
        Person person = new Person(null,dog, null,Arrays.asList(dog2,dog3),dogMap,null);

        FieldHandler.outProcess(person);
        System.out.println(person);
    }

}
