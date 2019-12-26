package conditionalStatment;

/**
 * Created by Sc on 8/10/2019.
 */
public class WhileDemo {

    public static void main(String[] args) {

        System.out.println(toHexString(1));

        System.out.println(10 & 20);

        System.out.println(4 & 0xF);

        System.out.println(4 | 0xF);

        System.out.println(1 << 4);
        System.out.println(10 >> 3);

        System.out.println(-1 >>> 2);

        byte b = -128;
        byte b1 = -1;
        // byte b2 = 128;
        System.out.println(b + b1);

    }


    public static String toHexString(int i) {
        StringBuffer buf = new StringBuffer(8);
        do {
            buf.append(Character.forDigit(i & 0xF, 16));
            i >>>= 4;
        } while (i != 0);
        return buf.reverse().toString();
    }

}
