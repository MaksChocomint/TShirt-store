package project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"project.color", "project.tshirt"})
@EntityScan(basePackages = {"project.color", "project.tshirt"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

