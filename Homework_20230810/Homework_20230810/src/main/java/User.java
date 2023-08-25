import java.util.List;
import java.util.Objects;

//        User:
//
//        Поля:
//        int id
//        String username
//        String email
//        List<Role> roles
//        Методы:
//        getUserInfo(): Возвращает строку с информацией о пользователе.
//        addRole(Role role): Добавляет роль пользователю.
//        removeRole(Role role): Удаляет роль у пользователя.
//        Бизнес-логика: Класс описывает пользователя с уникальным идентификатором, именем, адресом электронной почты и списком ролей. Пользователь может иметь несколько ролей.
//
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private boolean accessIsGranted;
    private List<Role> roles;


    public User(int id, String username, String password, String email, boolean accessIsGranted, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accessIsGranted = accessIsGranted;
        this.roles = roles;
    }

    //Возвращает строку с информацией о пользователе.
    public String getUserInfo() {
        return toString();
    }

    //Добавляет роль пользователю.
    public void addRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role is NULL");
        }
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }

    //Удаляет роль у пользователя.
    public void removeRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role to be deleted is NULL");
        }
        roles.remove(role);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean getAccessIsGranted() {
        return accessIsGranted;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setAccessIsGranted(boolean accessIsGranted) {
        this.accessIsGranted = accessIsGranted;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
