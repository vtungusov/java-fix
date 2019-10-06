package ru.vtungusov.repositories;

import ru.vtungusov.fake.FakeStorage;
import ru.vtungusov.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryInMemoryImp implements UsersRepository {

    public List<User> findAll() {
        return FakeStorage.storage().users();
    }

    @Override
    public void save(User user) {
        FakeStorage.storage().users().add(user);
    }

    @Override
    public boolean isExist(String name, String password) {
        boolean result = false;
        for (User user : FakeStorage.storage().users()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
