package com.lilingyan.fieldhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author lilingyan
 * @date 2019/11/24 下午10:33
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private String name;
    private Dog dog;

    List<Dog> dogList;
    List<Dog> dogList2;

    private Map<String,Dog> dogMap;
    private Map<String,Dog> dogMap2;

}
