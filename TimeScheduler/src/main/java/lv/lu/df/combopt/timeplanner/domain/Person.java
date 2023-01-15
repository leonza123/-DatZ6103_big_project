package lv.lu.df.combopt.timeplanner.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name", scope = Person.class)
public class Person {
    private String name;

    public Person() {}

    public Person(String name)
    {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }
}
