package ATM.States;

import ATM.RoomComponents.ATM;
import ATM.RoomComponents.Card;
import ATM.Enums.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPs!! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPs!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        System.out.println("OOPs!! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        System.out.println("OOPs!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPs!! Something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPs!! Something went wrong");
    }

    public void exit(ATM atm) {
        System.out.println("OOPs!! Something went wrong");
    }
}