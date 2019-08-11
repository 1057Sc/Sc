package conditionalStatment;

class TooMany {
    static void howMany(int k) {
        switch (k) {
            case 1: System.out.print("one ");
            case 2: System.out.print("too ");
            case 3: System.out.println("many");
        }
    }
    public static void main(String[] args) {
        howMany(3);
        howMany(2);
        howMany(1);

        System.out.println("--------------------------------------");

        howMany1(3);
        howMany1(2);
        howMany1(1);
    }


    static void howMany1(int k) {
        switch (k) {
            case 1: System.out.println("one");
                break;  // exit the switch
            case 2: System.out.println("two");
                break;  // exit the switch
            case 3: System.out.println("many");
                break;  // not needed, but good style
        }
    }
}