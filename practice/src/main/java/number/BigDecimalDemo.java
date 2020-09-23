package number;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class BigDecimalDemo {


    @Test
    public void demo() {
        Double currentScore = 0.984028445932d;
        Double timeSign = (1 - System.currentTimeMillis() / 100000000000000d) / 1000d;

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
    public void demo5() {
        double timeSign = (1 - (System.currentTimeMillis() / 1E+13d)) / 1E+8d;
        System.out.println(1 + timeSign);
    }

    @Test
    public void demo6() {
        int i = 1 % 2;
        System.out.println(i);
    }


    @Test
    public void demo7() {
        System.out.println(DateUtil.format(new Date(), "HHmmssSSS"));
        String format = DateUtil.format(new Date(), "9HHmmssSSS");
        System.out.println(format);

        double s = Long.parseLong(format) / 1E+10d;
        System.out.println(s);

        double s1 = 1 - s;
        System.out.println(s1);
        System.out.println((1 - (System.currentTimeMillis() / 1E+13d)));


        double s22 = (1 - (System.currentTimeMillis() / 1E+13d)) / 1E+10d;
        System.out.println(s22);


        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(40);
        System.out.println(nf.format(s22));
        double sss = 13123132432424234234.1231231231241241312432423413124234234213123324234131243242342342342342342342342423423423423423423442342342344234234234234234242424d;
        System.out.println(sss);
    }


    @Test
    public void demo8() {
        double dvalue = 0d;
        BigDecimal bigDecimal = new BigDecimal(dvalue);
        bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal newBigDecimal = bigDecimal;

        // DecimalFormat decimalFormat = new DecimalFormat("#,###.000000");//保留两位小数，并用都好隔开
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");//保留两位小数
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String result = decimalFormat.format(newBigDecimal);
        System.out.println(result);
        System.out.println(result.substring(result.length() - 4));
        String substring = result.substring(result.length() - 4);
        System.out.println(Integer.valueOf(substring));


        double a = 10000d;
        String s = String.valueOf((int)a);
        System.out.println(s.length());
    }

    @Test
    public void demo9(){
        double s = 1.0E-4;
        System.out.println(s);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(30);
        System.out.println(nf.format(s));
    }
}
