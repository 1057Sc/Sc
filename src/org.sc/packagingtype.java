/**
 * Created by Sc on 6/25/2019.
 */
public class packagingtype {

    public static void main(String[] args) {
        Integer i  = 1;
        int i2 = 1;
        Object i3 = (Object)i2;
        System.out.println(i.equals(i2));
        System.out.println(i==i2);
        System.out.println(i3 instanceof Integer);
    }
}
