package string.strbubber;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

public class Demo1 {

    @Test
    public void demo1() {
    }

    @Test
    public void replace() {
        StringBuffer s1 = new StringBuffer("1234");

/*
        System.out.println(s1.replace(0 ,1, "7"));

        System.out.println(s1.replace(7, 9, "7"));

        System.out.println(s1.length());

        int a = s1.indexOf("a");
        System.out.println(a);

*/
        System.out.println(s1.replace(s1.length() - 3, s1.length(), ""));

    }


    @Test
    public void demo2() {
        BigDecimal balance = BigDecimal.ZERO;
        BigDecimal balanceOne = null;
        boolean subtract = false;


        StringBuffer sql = new StringBuffer();
        StringBuffer whereSql = new StringBuffer();

        if (Objects.nonNull(balance) || Objects.nonNull(balanceOne)) {
            sql.append("update ").append("table").append(" set ");

            HashMap<String, Object> param = new HashMap<>();
            param.put("balance", balance);
            param.put("balanceOne", balanceOne);

            param.forEach((k, v) -> {
                if (Objects.nonNull(v)) {
                    if (subtract) {
                        sql.append(k).append(" = ").append(k).append(" - :").append(k).append(" , ");
                        whereSql.append(" and ").append(k).append(" >= :").append(k);
                    } else {
                        sql.append(k).append(" = ").append(k).append(" + :").append(k).append(" , ");
                    }
                }
            });
            sql.replace(sql.length() - 2, sql.length(), "");

            sql.append("where userId = :userId").append(whereSql);
        }

        System.out.println(sql.toString());

    }

    @Test
    public void demo4(){
        String materialCodePrefix = "SUT";
        String pre = "SU";
        String materialCode = "SUT00001";
        String materialCode1 = "SU00001";
        String prefix = StringUtils.substring(materialCode, 0, materialCodePrefix.length());
        if (StringUtils.equals(prefix, materialCodePrefix)) {
            System.out.println(StringUtils.replace(materialCode, materialCodePrefix, pre));
        }

        String prefix1 = StringUtils.substring(materialCode1, 0, materialCodePrefix.length());
        if (StringUtils.equals(prefix1, materialCodePrefix)) {
            System.out.println("21321321");
        }
        System.out.println(prefix1);
    }


}
