package productApp.entities;
public class User extends Entity {
    private String userName;

    private int age;

    private String email;

    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return ((((((((((("User = [ " + "userName='") + userName) + '\'') + ", age=") + age) + ", email='") + email) + '\'') + ", password='") + password) + '\'') + ']';
    }
}