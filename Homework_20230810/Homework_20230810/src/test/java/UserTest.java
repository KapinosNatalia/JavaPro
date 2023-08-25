import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    Role role1 = new Role(1, "role1", "description1");
    Role role2 = new Role(2, "role2", "description2");
    Role role3 = new Role(3, "role3", "description3");

    @BeforeEach
    void setUp() {
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);
        user = new User(1, "username", "password", "email", false, roles);
    }
    @Test
    void addRoleTest() {
        user.addRole(role3);
        Assertions.assertEquals(3, user.getRoles().size());
    }

    @Test
    void addRoleNullExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> user.addRole(null));
    }

    @Test
    void addExistentRoleTest() {
        user.addRole(role2);
        Assertions.assertEquals(2, user.getRoles().size());
    }

    @Test
    void removeRoleTest() {
        user.removeRole(role2);
        Assertions.assertEquals(1, user.getRoles().size());
    }

    @Test
    void removeRoleNullExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> user.removeRole(null));
    }

    @Test
    void removeNonexistentRoleTest() {
        user.removeRole(role3);
        Assertions.assertEquals(2, user.getRoles().size());
    }

}