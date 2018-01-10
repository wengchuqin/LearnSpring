package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.impl.CDPlayer;
import soundsystem.impl.SgtPeppers;

//@Configuration标记配置类
@Configuration
public class CDPlayerConfig {


    //@Bean标记产生Bean的方法，该方法产生的Bean叫‘compactDisc’
    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}
