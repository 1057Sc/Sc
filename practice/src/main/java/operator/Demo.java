package operator;

/**
 * @author Sc
 * @date 2021/5/14
 */
public class Demo {

    public Integer one = 1 << 1;
    public Integer two = 1 << 2;
    public Integer three = 1 << 3;
    public Integer four = 1 << 4;


    public static void main(String[] args) {
/*        char[] chs = {'0','1'};
        per(new char[2], chs, 2-1);*/
        System.out.println(1 << 2);
        System.out.println(3 & 1);
    }


    public static void per(char[] buf, char[] chs, int len) {
        if (len == -1) {
            for (int i = buf.length - 1; i >= 0; --i)
                System.out.print(buf[i]);
            System.out.println();
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            buf[len] = chs[i];
            per(buf, chs, len - 1);
        }
    }


}
