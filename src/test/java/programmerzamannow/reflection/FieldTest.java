package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName()+" : "+field.getType().getName());
        }
    }

    @Test
    void testGetFieldsValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);
        Person person1 = new Person("Hanif", "Faiz");

        String result = (String) firstName.get(person1);
        System.out.println(result);

        Person person2 = new Person("Haikal", "Aziz");

        String result2 = (String) firstName.get(person1);
        System.out.println(result2);
    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Hanif", "Faiz");
        firstName.set(person1,"Haikal");
        System.out.println(person1.getFirstName());


    }


}
