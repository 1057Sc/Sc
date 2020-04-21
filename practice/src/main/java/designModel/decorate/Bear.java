package designModel.decorate;

public class Bear extends AnimalDecorator {

    public Bear(AnimalHome bear) {
        super(bear);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "I am bear, go home";
    }

    @Override
    protected int movementSpeed() {
        return super.movementSpeed() + 10;
    }
}
