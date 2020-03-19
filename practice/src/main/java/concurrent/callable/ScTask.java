package concurrent.callable;

import java.util.concurrent.Callable;

public class ScTask implements Callable<Integer> {

    int number;

    public ScTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int fact=1;
        if(number < 0)
            throw new InvalidParamaterException("Number must be positive");

        for(int count=number;count>1;count--){
            fact=fact * count;
        }

        return fact;
    }

    private class InvalidParamaterException extends Exception {
        public InvalidParamaterException(String message) {
            super(message);
        }
    }

}
