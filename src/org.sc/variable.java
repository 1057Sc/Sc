import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duizhuang on 7/19/2019.
 */
public class variable {

    public static void main(String[] args) {
        confirmRole("1111",(short)1,(short)3);

        List<Short> list = new ArrayList<>();
        list.add((short)1);
        list.add((short)1);
        list.add((short)1);
        list.add((short)1);
        list.add((short)1);
    }

    public static List confirmRole(String userId, Short... codes) {

        System.out.println(userId);
        System.out.println(Arrays.toString(codes));
        return null;
    }
}
