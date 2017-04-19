package sample.aop.monitor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sample.aop.service.HelloAnchorService;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author neo.pan
 * @since 17/4/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
    AnchorMonitorTest.Config.class,
})
public class AnchorMonitorTest {

    @Autowired
    private HelloAnchorService service;

    @Test
    public void replaceFirstArgIfNull() throws Exception {
        String output = service.getHelloMessage(null, "Spring Test1");
        assertThat(output).isEqualTo("Hello AOP & Spring Test1");
    }

    @Test
    public void dontReplaceFirstArgIfNotNull() throws Exception {
        String output = service.getHelloMessage("DDD", "Spring Test2");
        assertThat(output).isEqualTo("Hello DDD & Spring Test2");
    }

    @TestConfiguration
    @EnableAutoConfiguration
    static class Config {
    }
}
