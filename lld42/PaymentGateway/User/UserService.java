package PaymentGateway.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {

    static List<User> usersList = new ArrayList<>();

    public UserDO addUser(UserDO userDO) {
        // do some validations
        User user = new User();

        user.setUserName(userDO.getName());
        user.setEmail(userDO.getMail());
        user.setUserId((int) new Random().nextInt(100 - 10) + 10);
        usersList.add(user);

        return convertUserDOToUser(user);
    }

    private UserDO convertUserDOToUser(User userObj) {
        UserDO userDO = new UserDO();

        userDO.setName(userObj.getUserName());
        userDO.setMail(userObj.getEmail());
        userDO.setId(userObj.getUserId());

        return userDO;
    }

    public UserDO getUser(int userId) {
        for (User user : usersList) {
            if (user.getUserId() == userId) {
                return convertUserDOToUser(user);
            }
        }

        return null;
    }
}