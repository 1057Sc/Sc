package org.sc.el;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author Sc
 * @date 2021/4/12
 */
@Component
public class ElDemos implements CommandLineRunner {


    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    public String evaluateExpression(String myString) {
        ConfigurableListableBeanFactory beanFactory =
                configurableApplicationContext.getBeanFactory();
        StringValueResolver str = new EmbeddedValueResolver(beanFactory);
        return str.resolveStringValue(myString);
        //Put Above statement in Try catch .. Worked for me
    }

    public void contextDemo(){
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");

        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("newName", "Mike Tesla");

        SpelExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("name = #newName").getValue(context, tesla);
        System.out.println(tesla.getName()); // "Mike Tesla"
    }


    @Override
    public void run(String... args) throws Exception {
        // String s = evaluateExpression("#{'hello'}");
        // System.out.println(s);
        contextDemo();
    }
}
