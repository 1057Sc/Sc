package util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by duizhuang on 8/29/2019.
 */
public class EscapeSql {


    public static String apply(String charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (StringUtils.contains(charSequence,"--")) {
            charSequence = StringUtils.replace(charSequence, "--", "'--'");
        }
        if (StringUtils.contains(charSequence," and ")) {
            charSequence = StringUtils.replace(charSequence, "and", "'and'");
        }
        if (StringUtils.contains(charSequence," where ")) {
            charSequence = StringUtils.replace(charSequence, "where", "'where'");
        }
        if (StringUtils.contains(charSequence," or ")) {
            charSequence = StringUtils.replace(charSequence, "or", "'or'");
        }


        return charSequence;
    }

    public static void main(String[] args) {
        String sql = " where 1=1 or 1=1 -- or1=1";
        String apply = apply(sql);
        System.out.println(apply);

        String sql1 = "or ";
        String apply1 = apply(sql1);
        System.out.println(apply1);
    }
}