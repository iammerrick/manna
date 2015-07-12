package manna;

import manna.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    @Autowired
    UserRepository repository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }

}