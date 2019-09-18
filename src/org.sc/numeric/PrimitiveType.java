package numeric;

import org.junit.Test;
import refect.Student;

public class PrimitiveType {

    @Test
    public void compare(){
        short i = 1;
        Short j = 1;
        Short z = 1;
        Short zi  = new Short((short) 1);
        System.out.println(i == j);
        System.out.println(z == j);
        System.out.println(j.equals(i));
        System.out.println(z == zi);
    }
}
