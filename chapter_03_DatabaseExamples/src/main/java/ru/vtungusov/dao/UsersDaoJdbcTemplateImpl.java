package ru.vtungusov.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.vtungusov.db.models.Car;
import ru.vtungusov.db.models.User;

import javax.sql.DataSource;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UsersDao {

    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_ALL =
            "SELECT * FROM fix_user";

    //language=SQL
    private final String SQL_SELECT_BY_FIRST_NAME =
            "SELECT * FROM fix_user WHERE first_name = ?";

    private Map<Integer, User> userMap = new HashMap<>();

    //language=SQL
    private final String SQL_SELECT_USER_WITH_CARS =
            "SELECT fix_user.*, fix_car.id AS car_id, fix_car.model FROM  fix_user LEFT JOIN fix_car ON fix_user.id = fix_car.owner_id WHERE fix_user.id = ?";

    private RowMapper<User> userRowMapper = (resultSet, i) -> new User(
            resultSet.getInt("id"),
            resultSet.getString("first_name"),
            resultSet.getString("last_name"));

    private RowMapper<User> userWithCarRowMapper = (resultSet, i) -> {
        Integer id = resultSet.getInt("id");
        if (!userMap.containsKey(id)) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            userMap.put(id, new User(id, firstName, lastName, new ArrayList<>()));
        }
        User user = userMap.get(id);
        Integer carId = resultSet.getInt("car_id");
        String carModel = resultSet.getString("model");
        Car car = new Car(carId, carModel, user);
        user.getCars().add(car);
        return user;
    };

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return template.query(SQL_SELECT_BY_FIRST_NAME, userRowMapper, firstName);
    }

    @Override
    public Optional<User> find(Integer id) {
        template.query(SQL_SELECT_USER_WITH_CARS, userWithCarRowMapper, id);

        Optional<User> result;
        if (userMap.containsKey(id)) {
            result = Optional.of(userMap.get(id));
        } else {
            result = Optional.empty();
        }
        return result;
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }
}
