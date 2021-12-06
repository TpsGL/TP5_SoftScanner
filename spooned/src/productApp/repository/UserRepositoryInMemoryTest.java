package productApp.repository;
import productApp.entities.User;
import productApp.strategy.InMemoryStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class UserRepositoryInMemoryTest {
    UserRepository userRepository;

    User user;

    User userInMemory;

    @BeforeEach
    public void setUp() {
        userRepository = UserRepository.getInstance();
        userRepository.init(new InMemoryStrategy<User>());
        user = new User();
        user.setUserName("mahio");
        user.setAge(23);
        user.setEmail("gm_begoug@esi.dz");
        user.setPassword("1Hamza@123!");
        userInMemory = userRepository.add(user);
    }

    @Test
    public void can_add_user() {
        assertNotNull(userInMemory.getId());
        assertEquals("mahio", userInMemory.getUserName());
        assertEquals(23, userInMemory.getAge());
        assertEquals("gm_begoug@esi.dz", userInMemory.getEmail());
        assertEquals("1Hamza@123!", userInMemory.getPassword());
    }
}