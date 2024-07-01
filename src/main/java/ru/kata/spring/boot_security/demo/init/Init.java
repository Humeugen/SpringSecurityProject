package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class Init {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public Init(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void run() {
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");

        roleService.addRole(admin);
        roleService.addRole(user);

        userService.addUser(new User("John", "Smith", "John",
                "AgentSmith@freedom.net", "matrixhasyou", Set.of(admin)));
        userService.addUser(new User("Tomas", "Andersen", "Neo",
                "Zeon@zeon.org", "followthewhiterabbit", Set.of(user)));
    }
}
