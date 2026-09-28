package Splitwise;

import java.util.ArrayList;
import java.util.List;

import Splitwise.Expense.ExpenseSplitType;
import Splitwise.Expense.Split.Split;
import Splitwise.Group.Group;
import Splitwise.Group.GroupController;
import Splitwise.User.User;
import Splitwise.User.UserController;
import Splitwise.Balance.BalanceSheetController;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void setupUserAndGroup() {
        // onboard user to splitwise app
        addUsersToSplitwiseApp();

        // Create a group by user1
        User user1 = userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing with Friends", user1);
    }

    public void addUsersToSplitwiseApp() {
        User user1 = new User("U1001", "User1");
        User user2 = new User("U2001", "User2");
        User user3 = new User("U3001", "User3");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

    public void demo() {
        setupUserAndGroup();

        // Step:1 - Add members to the group
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U3001"));

        // Step:2 - Create an expense inside a group
        List<Split> splits1 = new ArrayList<>();
        Split split1_1 = new Split(userController.getUser("U1001"), 300);
        Split split1_2 = new Split(userController.getUser("U2001"), 300);
        Split split1_3 = new Split(userController.getUser("U3001"), 300);
        splits1.add(split1_1);
        splits1.add(split1_2);
        splits1.add(split1_3);
        group.createExpense("Exp1001", "Breakfast", 900, splits1, ExpenseSplitType.EQUAL,
                userController.getUser("U1001"));

        List<Split> splits2 = new ArrayList<>();
        Split split2_1 = new Split(userController.getUser("U1001"), 300);
        Split split2_2 = new Split(userController.getUser("U2001"), 300);
        splits2.add(split2_1);
        splits2.add(split2_2);
        group.createExpense("Exp1002", "Lunch", 500, splits2, ExpenseSplitType.UNEQUAL,
                userController.getUser("U2001"));

        for (User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }
}