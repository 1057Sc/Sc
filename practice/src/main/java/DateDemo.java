import java.util.Calendar;
import java.util.*;

/**
 * Created by Sc on 6/1/2019.
 */
public class DateDemo
{


    public static void main(String[] args) {
        Demo1();
        dateString();
    }

    public static void Demo1()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),23,59,59);

        long l1 = calendar.getTimeInMillis();
        java.util.Date date = calendar.getTime();
        Long tt = calendar.getTime().getTime()/1000;
        System.out.println(l1);
        System.out.println(date);
        System.out.println(tt);

    }

    public static Integer getRemainSecondsOneDay(Date currentDate) {
        Calendar midnight=Calendar.getInstance();
        midnight.setTime(currentDate);
        midnight.add(midnight.DAY_OF_MONTH,1);
        midnight.set(midnight.HOUR_OF_DAY,0);
        midnight.set(midnight.MINUTE,0);
        midnight.set(midnight.SECOND,0);
        midnight.set(midnight.MILLISECOND,0);
        Integer seconds=(int)((midnight.getTime().getTime()-currentDate.getTime())/1000);
        return seconds;
    }

    public static void dateString(){
        String whereSql = " start_time > TIMESTAMP '"+"2019-05-12 16:25:18"+"' ";
        System.out.println(whereSql);
    }


}
