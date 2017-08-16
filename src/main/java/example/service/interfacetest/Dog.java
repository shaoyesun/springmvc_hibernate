package example.service.interfacetest;

import org.springframework.stereotype.Service;

/**
 * Created by root on 17-8-16.
 */
@Service("dog")
public class Dog implements Animal {

    public String myName() {
        System.out.println("I am Dog");
        return "dog";
    }

}
