import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {
    UserDatabase userDatabase = new UserDatabase();

    @Mock
    List<Role> roleList;
    User user1 = new User(1, "username1", "pass1", "email1", true, roleList);
    User user2 = new User(2, "username2", "pass2", "email2", true, roleList);
    User user3 = new User(3, "username3", "pass3", "email3", true, roleList);

    @Test
    void getUserByIdTest() {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        Assertions.assertEquals(user1, userDatabase.getUserById(1));
    }

    @Test
    void getUserByIdExceptionTest() {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.getUserById(0));
        Assertions.assertThrows(UserNotFoundException.class, () -> userDatabase.getUserById(15));
    }
    @Test
    void getUserByUsernameTest() {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        Assertions.assertEquals(user2, userDatabase.getUserByUsername("username2"));
    }

    @Test
    void getUserByUsernameExceptionTest() {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        Assertions.assertThrows(UserNotFoundException.class, () -> userDatabase.getUserByUsername("user4"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.getUserByUsername(""));
    }

    @Test
    void addUserTest() {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        userDatabase.addUser(user3);
        Assertions.assertEquals(3, userDatabase.getUsers().size());
    }

    @Test
    void addUserExceptionTest() {
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);
        userDatabase.getUsers().size();
        Assertions.assertThrows(IllegalArgumentException.class, () -> userDatabase.addUser(null));
        User user1_1 = new User(1, "username1_1", "pass1_1", "email1_1", true, roleList);    User user1 = new User(1, "username1", "pass1", "email1", true, roleList);
        User user1_2 = new User(12, "username1", "pass1_2", "email1_2", true, roleList);
        Assertions.assertThrows(AuthenticationErrorException.class, () -> userDatabase.addUser(user1_1));
        Assertions.assertThrows(AuthenticationErrorException.class, () -> userDatabase.addUser(user1_2));
    }
}