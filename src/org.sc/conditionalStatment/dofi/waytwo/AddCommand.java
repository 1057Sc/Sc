package conditionalStatment.dofi.waytwo;

/**
 * Created by duizhuang on 8/29/2019.
 */
public class AddCommand implements Command {
    // Instance variables

    private int a;

    private int b;


    public AddCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer execute() {
        return a + b;
    }
}
