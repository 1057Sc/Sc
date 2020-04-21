package designModel.decorate;

public class RunClazz {

    public static void main(String[] args) {
        AnimalHome animal;

        animal = new AnimalHome() {
            @Override
            protected String getDesc() {
                return "7777";
            }

            @Override
            protected int movementSpeed() {
                return 0;
            }
        };

        animal = new Bear(animal);

        animal = new Dog(animal);

        System.out.println(animal.getDesc() + ":::::::::" + animal.movementSpeed());
    }
}
