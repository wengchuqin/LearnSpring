package conditionbean;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by wengchuqin on 2018/1/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MagicConfig.class)
public class MagicBeanTest {
    @Autowired
    private ApplicationContext context;

    @BeforeClass
    public static void setMagicProperty(){
        System.setProperty("magic", "hello magic");
    }

    /*
     * This test will fail until you set a "magic" property.
     * You can set this property as an environment variable, a JVM system property, by adding a @BeforeClass
     * method and calling System.setProperty() or one of several other options.
     */
    @Test
    public void shouldNotBeNull() {
        assertTrue(context.containsBean("magicBean"));
    }
}