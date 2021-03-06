package date;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.util.TextUtils;
import org.joda.time.DateTime;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Sc on 6/7/2019.
 */
public class DateDemo {

    public static void main(String[] args) {
        System.out.println(new Date());

        System.out.println(DateTime.now());

        Date time = new Date();

        DateTime jodaTime = DateTime.now();

        // long millis = new DateTime().withTime(23, 59, 59, 0);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss:SSS");

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();

        String startTime = simpleDateFormat.format(start);

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date end = calendar.getTime();

        // String ss = DateFormatUtil.convertToString(start.getTime());
        System.out.println(start);
        System.out.println(end);
        System.out.println(startTime);

    }

    @Test
    public void demo1() {
        // 获取当天到0点的时间
        String timeZone = "GMT+8";
        String tz = TextUtils.isEmpty(timeZone) ? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(new Date().getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        System.out.println(new Timestamp(calendar.getTime().getTime()));
    }

    @Test
    public void demo2() {
        Date date = new Date();
        cn.hutool.core.date.DateTime dateTime = DateUtil.endOfDay(date);
        System.out.println(dateTime.getField(DateField.SECOND));
        System.out.println(date.getTime());


        cn.hutool.core.date.DateTime dateTime1 = DateUtil.endOfDay(new Date());
        System.out.println(dateTime1.getTime());
    }

    @Test
    public void demo3() {
        cn.hutool.core.date.DateTime dateTime = DateUtil.endOfWeek(DateUtil.nextWeek());
        System.out.println(dateTime.getTime());
    }

    @Test
    public void demo4() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.MILLISECOND));
    }

    @Test
    public void demo5() {
        System.out.println(DateUtil.format(new Date(), "HHmmssSSS"));


        String format = DateUtil.format(new Date(), "9HHmmssSSS");
        System.out.println(format);

        double s = Long.parseLong(format) / 1E+10d;
        System.out.println(s);

        System.out.println(1 - s);

        //System.out.println((double) 1 - ((Long.parseLong(format) / 1E+10d)));

        // System.out.println(hHmmssSSS / 1E+10d);
    }
}
