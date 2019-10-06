package ru.vtungusov.fake;

import ru.vtungusov.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        this.users = Arrays.asList(
                new User("Vasia", "123", LocalDate.parse("1999-02-26")),
                new User("Fedia", "1234", LocalDate.parse("1999-04-12")),
                new User("Petia", "G42g#@34dsfG@234wer!(&*G3e", LocalDate.parse("1999-04-12"))
        );
    }

    public static FakeStorage storage() {
        return storage;
    }
}
