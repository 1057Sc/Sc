package date;


import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
