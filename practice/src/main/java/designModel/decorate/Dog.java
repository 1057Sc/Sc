package designModel.decorate;

public class Dog extends AnimalDecorator {

    public Dog(AnimalHome animal) {
        super(animal);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "I am dog ,go home";
    }

    @Override
    protected int movementSpeed() {
        return super.movementSpeed() + 20;
    }
}
