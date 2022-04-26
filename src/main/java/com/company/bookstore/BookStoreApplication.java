package com.company.bookstore;

import com.company.bookstore.entity.Role;
import com.company.bookstore.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BookStoreApplication implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role(1, "ROLE_USER");
        Role rolePublisher = new Role(2, "ROLE_PUBLISHER");
        roleRepository.save(role);
        roleRepository.save(rolePublisher);


    }

}
