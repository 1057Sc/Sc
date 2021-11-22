package enumdemo;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhuqingxin
 * @date 2021/7/27
 */
@Getter
public enum CodeInfoEnum {

    LOCK(1L, 1L, "LOCK_TYPE", "LOCK"),
    UNLOCK(1L, 2L, "LOCK_TYPE", "LOCK");

    public Long classId;
    public Long infoId;
    public String classCode;
    public String infoCode;

    CodeInfoEnum(Long classId, Long infoId, String classCode, String infoCode) {
        this.classId = classId;
        this.infoId = infoId;
        this.classCode = classCode;
        this.infoCode = infoCode;
    }

    CodeInfoEnum() {
    }

    public static CodeInfoEnum getByInfoId(Long infoId) {
        return CodeInfoEnum.valueOf(infoId + "");
    }

    public static List<CodeInfoEnum> getByClassId(Long classId) {
        return Arrays.stream(CodeInfoEnum.values()).filter(item -> item.classId.equals(classId)).collect(Collectors.toList());
    }

    public static CodeInfoEnum getByClassCodeAndInfoCode(String classCode, String infoCode) {
        Optional<CodeInfoEnum> opt = Arrays.stream(CodeInfoEnum.values()).filter(item -> item.classCode.equals(classCode) && item.infoCode.equals(infoCode)).findFirst();
        return opt.orElse(null);
    }

    @Override
    public String toString() {
        return "CodeInfoEnum{" +
                "classId=" + classId +
                ", infoId=" + infoId +
                ", classCode='" + classCode + '\'' +
                ", infoCode='" + infoCode + '\'' +
                '}';
    }

}
