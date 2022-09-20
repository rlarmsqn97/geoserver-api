package jbt.boo.some;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("부","SFda","SDFa");
        stringList.stream()
                .filter(list -> list.equals("부"))
                .forEach(System.out::println);
        System.out.println(stringList);
    }
}
