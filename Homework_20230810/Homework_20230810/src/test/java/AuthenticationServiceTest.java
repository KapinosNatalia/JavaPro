import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    @Mock
    List<Role> roleList;
    User user1 = new User(1, "username1", "pass1", "email1", true, roleList);
    User user2 = new User(2, "username2", "pass2", "email2", false, roleList);
    UserDatabase userDatabase = new UserDatabase(List.of(user1, user2));
    AuthenticationService authenticationService = new AuthenticationService(userDatabase);

    @Test
    void authenticateTest() {
        Assertions.assertTrue(authenticationService.authenticate("username1", "pass1"));
    }

    @Test
    void authenticateExceptionTest() {;
        // username or password is empty
        Assertions.assertThrows(IllegalArgumentException.class, () -> authenticationService.authenticate("", null));

        // there are no user with given username
        Assertions.assertThrows(UserNotFoundException.class, () -> authenticationService.authenticate("username3", "pass2"));

        // access is revoked
        Assertions.assertThrows(AuthenticationErrorException.class, () -> authenticationService.authenticate("username2", "pass2"));
    }

    @Test
    void changeAccessExceptionTest() {
        // user is NULL
        Assertions.assertThrows(IllegalArgumentException.class, () -> authenticationService.grantAccess(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> authenticationService.revokeAccess(null));
    }

    @Test
    void grantAccessTest() {
        Assertions.assertThrows(AuthenticationErrorException.class, () -> authenticationService.authenticate("username2", "pass2"));
        authenticationService.grantAccess(user2);
        Assertions.assertTrue(authenticationService.authenticate("username2", "pass2"));
    }

    @Test
    void revokeAccessTest() {
        Assertions.assertTrue(authenticationService.authenticate("username1", "pass1"));
        authenticationService.revokeAccess(user1);
        Assertions.assertThrows(AuthenticationErrorException.class, () -> authenticationService.authenticate("username1", "pass1"));
    }

}