package enumdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum EnumCode {
    demo1(1,1)
    ;

    public void setValue(int value) {
        this.value = value;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int value;

    private int code;


}
