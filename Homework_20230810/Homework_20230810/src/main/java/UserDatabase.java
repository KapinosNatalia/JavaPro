import javax.print.attribute.UnmodifiableSetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//        UserDatabase:
//
//        Поля:
//        List<User> users
//        Методы:
//        getUserById(int id): Возвращает пользователя по его идентификатору.
//        getUserByUsername(String username): Возвращает пользователя по имени пользователя.
//        addUser(User user): Добавляет нового пользователя в базу данных.
//        Бизнес-логика: Класс управляет хранением и доступом к пользователям.
public class UserDatabase {
    private List<User> users = new ArrayList<>();

    public UserDatabase() {
    }

    public UserDatabase(List<User> users) {
        this.users = users;
    }

    //Возвращает пользователя по его идентификатору.
    public User getUserById(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("ID should be 1 or more");
        }
        return users.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException("Can't find User with ID " + id));
    }

    //Возвращает пользователя по имени пользователя.
    public User getUserByUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username is empty");
        }
        return users.stream()
            .filter(user -> username.equals(user.getUsername()))
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException("Can't find user with name " + username));
    }

    //Добавляет нового пользователя в базу данных.
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is NULL");
        }
        if (users.isEmpty()) {
            users.add(user);
        } else {
            if (users.stream().anyMatch(us -> us.getId() == user.getId())) {
                throw new AuthenticationErrorException("User with ID " + user.getId() + " already exist");
            } else if (users.stream().anyMatch(us -> us.getUsername().equals(user.getUsername()))) {
                throw new AuthenticationErrorException("User with Username " + user.getUsername() + " already exist");
            } else {
                users.add(user);
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
