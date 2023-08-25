//        AuthenticationService:
//
//        Поля:
//        UserDatabase userDatabase
//        Методы:
//        authenticate(String username, String password): Проверяет аутентификацию пользователя.
//        grantAccess(User user): Предоставляет доступ пользователю.
//        revokeAccess(User user): Отзывает доступ у пользователя.
//        Бизнес-логика: Класс предоставляет методы для аутентификации пользователей, предоставления и отзыва доступа.
public class AuthenticationService {
    private UserDatabase userDatabase;

    public AuthenticationService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    //Проверяет аутентификацию пользователя.
    public boolean authenticate(String username, String password) throws UserNotFoundException, AuthenticationErrorException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and Password should be not empty");
        }
        User user = userDatabase.getUserByUsername(username);
        if (user != null && password.equals(user.getPassword()) && user.getAccessIsGranted()) {
            return true;
        } else {
            throw new AuthenticationErrorException("Authentication error");
        }
    }

    //Предоставляет доступ пользователю.
    public void grantAccess(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is NULL");
        }
        user.setAccessIsGranted(true);
    }

    //Отзывает доступ у пользователя.
    public void revokeAccess(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is NULL");
        }
        user.setAccessIsGranted(false);
    }
}
