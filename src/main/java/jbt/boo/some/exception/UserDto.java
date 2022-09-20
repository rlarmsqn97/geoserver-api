package jbt.boo.some.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class UserDto {
    @NotNull(message = "번호에 Null값을 넣을 수 없습니다.")
    private long no;

    @NotNull(message = "이름에 Null값을 넣을 수 없습니다.")
    private String name;
}
