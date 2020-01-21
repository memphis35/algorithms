package com.company.model;

import com.company.model.Person;
import org.junit.Test;

public class PersonTest {

    @Test
    public void displayTest() {
        Person test = new Person("Mike", "Collahan", 29);
        test.display();
    }

}
