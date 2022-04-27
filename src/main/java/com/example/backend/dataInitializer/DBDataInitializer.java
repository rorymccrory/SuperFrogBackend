package com.example.backend.dataInitializer;

import com.example.backend.dao.AppearanceDao;
import com.example.backend.dao.SuperFrogDao;
import com.example.backend.domain.Appearance;
import com.example.backend.domain.SuperFrog;
import com.example.backend.service.UserService;
import com.example.backend.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private AppearanceDao appearanceDao;
    private SuperFrogDao superFrogDao;
    private UserService userService;

    public DBDataInitializer(AppearanceDao appearanceDao, SuperFrogDao superFrogDao, UserService userService) {
        this.appearanceDao = appearanceDao;
        this.superFrogDao = superFrogDao;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Appearance a1 = new Appearance();
        a1.setId("1");
        a1.setTitle("Emma's Birthday");
        a1.setDate("07/02/2022");
        a1.setDescription("Celebrating Emma");
        a1.setEmail("e.m.sanders@tcu.edu");

        Appearance a2 = new Appearance();
        a2.setId("2");
        a2.setTitle("Logan's Birthday");
        a2.setDate("05/04/2022");
        a2.setDescription("Celebrating Logan");
        a2.setEmail("e.m.sanders@tcu.edu");

        SuperFrog sf1 = new SuperFrog();
        sf1.setEmail("b.wei@tcu.edu");
        sf1.addAppearance(a1);

        SuperFrog sf2 = new SuperFrog();
        sf2.setEmail("h.potter@tcu.edu");
        sf2.addAppearance(a2);

        superFrogDao.save(sf1);
        superFrogDao.save(sf2);

        User u1 = new User();
        u1.setUsername("john");
        u1.setPassword("123456");
        u1.setEnabled(true);
        u1.setRoles("director");

        User u2 = new User();
        u2.setUsername("eric");
        u2.setPassword("654321");
        u2.setEnabled(true);
        u2.setRoles("superfrog");

        User u3 = new User();
        u3.setUsername("tom");
        u3.setPassword("qwerty");
        u3.setEnabled(false);
        u3.setRoles("customer");

       userService.save(u1);
       userService.save(u2);
       userService.save(u3);

    }

}
