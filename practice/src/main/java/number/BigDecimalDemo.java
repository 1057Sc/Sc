package number;

import cn.hutool.core.date.DateUtil;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;

public class BigDecimalDemo {


    @Test
    public void demo() {
        Double currentScore = 0.984028445932d;
        Double timeSign = 1 - System.currentTimeMillis() / 100000000000000d;


        Double dif = timeSign - (currentScore - currentScore.intValue());
        System.out.println(timeSign);
        System.out.println(dif);
    }

    @Test
    public void demo1() {
        Double init = 0.000000984028445932d;


        Double timeSign = 1 - System.currentTimeMillis() / 10000000000000000d;

        Double currentScore = init + timeSign;
        System.out.println(currentScore);
        System.out.println(currentScore.intValue());
        Double dif = timeSign - (currentScore - currentScore.intValue());
        System.out.println(dif);

        int num = 10;

        BigDecimal bigDecimal = new BigDecimal(init);
        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal.doubleValue());

        BigDecimal add = BigDecimal.valueOf(num).add(new BigDecimal(init));
        System.out.println(add.toString());
    }

    @Test
    public void demo3() {

        double s = 1E+16;
        System.out.println(s);

        System.out.println(System.currentTimeMillis());

        Double init = 0.000000984028445932d;
        BigDecimal bigDecimal = new BigDecimal(init);
        System.out.println(bigDecimal.doubleValue());

        BigDecimal bd = new BigDecimal("3.14159265");
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bd.toString());

        BigDecimal curTime = new BigDecimal(System.currentTimeMillis());
        BigDecimal decimals = new BigDecimal(s);

        System.out.println(curTime.divide(decimals, 16, BigDecimal.ROUND_HALF_UP));


    }

    @Test
    public void dem3() {
        Calendar time = Calendar.getInstance();
        time.get(Calendar.HOUR_OF_DAY);//获取小时bai
        time.get(Calendar.MINUTE);//获取分钟
        time.get(Calendar.SECOND);//获取秒

        System.out.println(time.toString());
        System.out.println(time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE) + ":" + time.get(Calendar.SECOND));
        System.out.println(System.currentTimeMillis());
        System.out.println(time.getTime().getTime());

    }

    @Test
    public void demo4() {
        System.out.println(System.currentTimeMillis());

        double s1 = (1 - (System.currentTimeMillis() / 1E+13d)) / 1E+4d;
        System.out.println(s1);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(30);
        System.out.println(nf.format(s1));

        System.out.println();
        BigDecimal bigDecimal = new BigDecimal(1E+16d);
        double s = 1E+16d;
        BigDecimal subtract = BigDecimal.valueOf(1).subtract((new BigDecimal(System.currentTimeMillis()).divide(bigDecimal, 16, BigDecimal.ROUND_HALF_UP)));
        System.out.println(subtract.doubleValue());
    }

    @Test
    public void demo5(){
        double timeSign = (1 - (System.currentTimeMillis() / 1E+13d)) / 1E+8d;
        System.out.println(1 + timeSign);
    }

    @Test
    public void demo6(){
        int i = 1 % 2;
        System.out.println(i);
    }
}
