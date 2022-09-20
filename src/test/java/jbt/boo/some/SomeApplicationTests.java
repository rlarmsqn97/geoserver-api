package jbt.boo.some;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SomeApplicationTests {
    @Test
    void 불변() {
        final Map<String, String> collection = Map.of(
                "asdf","asdf","asfd","ASdf"
        );
        System.out.println(collection);
        assertThat(collection.size()).isEqualTo(1);
    }

}
