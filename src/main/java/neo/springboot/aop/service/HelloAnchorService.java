package neo.springboot.aop.service;

import neo.springboot.aop.monitor.Anchor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author neo.pan
 * @since 17/4/19
 */
@Component
public class HelloAnchorService {

    @Value("${name:World}")
    private String name;

    @Anchor(id = "AOP")
    public String getHelloMessage(String placeholder, String secondArg) {
        return "Hello " + (placeholder != null ? placeholder : this.name) + " & " + secondArg;
    }

}
