package example.service.interfacetest;

import org.springframework.stereotype.Service;

/**
 * Created by root on 17-8-16.
 */
@Service("cat")
public class Cat implements Animal {

    public String myName() {
        System.out.println("I am Cat");
        return "cat";
    }

}
