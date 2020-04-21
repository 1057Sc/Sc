package designModel.decorate;

public class AnimalDecorator extends AnimalHome {

    private AnimalHome animal;

    public AnimalDecorator(AnimalHome animal) {
        this.animal = animal;
    }

    @Override
    protected String getDesc() {
        return this.animal.getDesc();
    }

    @Override
    protected int movementSpeed() {
        return this.animal.movementSpeed();
    }
}
