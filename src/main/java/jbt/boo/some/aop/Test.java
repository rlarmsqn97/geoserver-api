package jbt.boo.some.aop;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        proxyTestA();
    }

    @PerfLogging // 어노테이션으로 코드 중복 없이 기능 추가 가능하다.
    public static void proxyTestA() {
        int sum = 0;
        List<Integer> integerList = new ArrayList();
        for (Integer i : integerList) {
            sum += i;
        }
        System.out.println(sum);
    }
}
