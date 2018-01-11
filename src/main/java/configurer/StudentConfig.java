package configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by wengchuqin on 2018/1/11.
 */
@Configuration
@PropertySource("classpath:student.properties")
public class StudentConfig {
    @Autowired
    Environment env;

    @Bean
    public Student student(){
        Student student = new Student();
        student.setName(env.getProperty("student.name"));
        return student;
    }
}
