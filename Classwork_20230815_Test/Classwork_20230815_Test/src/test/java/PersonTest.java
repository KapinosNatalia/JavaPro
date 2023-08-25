import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void isAdultTest() {
        Person personAdult = new Person("Ivan",25, "address", "email");
        Person personChild = new Person("Oleg", 10, "addres1", "email1");
        Assertions.assertTrue(personAdult.isAdult());
        Assertions.assertFalse(personChild.isAdult());
    }
}