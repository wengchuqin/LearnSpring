package configurer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by wengchuqin on 2018/1/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StudentConfig.class)
public class StudentConfigTest {
    @Autowired
    Student student;

    @Test
    public void testStudent() throws Exception {
        Assert.assertEquals(student.getName(), "wengchuqin");
    }
}