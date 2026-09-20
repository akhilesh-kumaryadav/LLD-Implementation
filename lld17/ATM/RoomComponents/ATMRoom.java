package ATM.RoomComponents;

import ATM.Enums.TransactionType;

public class ATMRoom {
    ATM atm;
    User user;

    public ATM getAtm() {
        return atm;
    }

    public User getUser() {
        return user;
    }

    public void initialize() {
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 1, 2, 5);

        this.user = createUser();
    }

    public User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    public Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    public UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);

        return bankAccount;
    }
}