package refect.annotation;

/**
 * Created by Sc on 2018/12/19.
 */
public class UseAnnotation {

    @DemoAnnotation.UseCases(id="2",description = "no")
    public String demo(String string){

        return string;
    }
}
