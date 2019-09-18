package conditionalStatment.dofi.waytwo;


/**
 * Created by Sc on 8/29/2019.
 */
public class Calculator {

    public int calculate(Command command) {
        return command.execute();
    }


  /*  @Test
    public void whenCalculateUsingCommand_thenReturnCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(new AddCommand(3, 7));
        assertEquals(10, result);
    }*/
}
