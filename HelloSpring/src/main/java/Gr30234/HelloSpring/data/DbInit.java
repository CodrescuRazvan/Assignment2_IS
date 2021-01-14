package Gr30234.HelloSpring.data;

import Gr30234.HelloSpring.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private UserJpaRepository userJpaRepository;
    private PasswordEncoder passwordConfig;

    public DbInit(UserJpaRepository userJpaRepository, PasswordEncoder passwordConfig) {
        this.userJpaRepository = userJpaRepository;
        this.passwordConfig = passwordConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userJpaRepository.deleteAll();

        User client = new User("client", passwordConfig.encode("client123"), "ADMIN");
        User admin = new User("admin", passwordConfig.encode("admin123"), "CLIENT");

        List<User> users = Arrays.asList(client, admin);
        this.userJpaRepository.saveAll(users);
    }
}
