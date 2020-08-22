package time;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Demo {

    private static final String default_format = "yyyy-MM-dd HH:mm:ss";
    private static final String yyyymm = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void unixTime() {
        long epochSecond = Instant.now().getEpochSecond();
        System.out.println(epochSecond);


        long unix = Instant.now().getEpochSecond() * 1000L;
        String now = DateUtil.now();

        String format = FastDateFormat.getInstance(default_format).format(new Date());
        System.out.println(format);

    }

    @Test
    public void week() {
        int i = DateUtil.weekOfYear(new Date());
        int i1 = DateUtil.weekOfYear(new Date(1451750400000L));
        int i12 = DateUtil.weekOfYear(new Date(1451491200000L));
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i12);

        int i2 = DateUtil.thisYear();
        System.out.println(i2);

        int year = DateUtil.year(new Date(1451750400000L));
        int year1 = DateUtil.year(new Date(1451491200000L));
        System.out.println(year);
        System.out.println(year1);

        // 判断周是否跨年
        DateTime dateTime = DateUtil.beginOfWeek(new Date(1451750400000L));
        System.out.println(dateTime.getField(DateField.YEAR));
        DateTime dateTime1 = DateUtil.endOfWeek(new Date(1451491200000L));
        System.out.println(dateTime1.getField(DateField.YEAR));
    }

    @Test
    public void demo() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        System.out.println(timeInMillis);
        System.out.println(timeInMillis / 1000);

        int curTime = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(curTime);
    }
}
