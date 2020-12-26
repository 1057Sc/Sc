package generate.entity;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class FooVODate {

    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }


    @Test
    public void demos() {
        FooLong fooLong = new FooLong();
        FooVODate fooDate = new FooVODate();
        BeanUtils.copyProperties(fooLong, fooDate);
        System.out.println(123);
    }
}
