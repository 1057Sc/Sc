package og.sc;

import org.junit.BeforeClass;
import org.mockito.MockitoAnnotations;
import org.sc.Application;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class BaseTest {

    @BeforeClass
    public static void initMockAnnotation() {
        MockitoAnnotations.initMocks(DemoTest.class);
    }


}
