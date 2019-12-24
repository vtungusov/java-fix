package ru.vtungusov.fake;

import org.mindrot.jbcrypt.BCrypt;
import ru.vtungusov.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private static final FakeStorage storage;

    static {
        storage = new FakeStorage();
    }

    public List<User> users() {
        return users;
    }

    private List<User> users;

    private FakeStorage() {
        this.users = new ArrayList<>();
        users.add(new User("Vasia", BCrypt.hashpw("123", BCrypt.gensalt()), LocalDate.parse("1999-02-26")));
        users.add(new User("Fedia", BCrypt.hashpw("1234", BCrypt.gensalt()), LocalDate.parse("1999-04-12")));
        users.add(new User("Petia", BCrypt.hashpw("321", BCrypt.gensalt()), LocalDate.parse("1999-04-12")));
        for (User user : users) {
            System.out.println(user.getName()+":"+user.getPassword()+":"+user.getBirthDate());
        }
    }

    public static FakeStorage storage() {
        return storage;
    }
}
