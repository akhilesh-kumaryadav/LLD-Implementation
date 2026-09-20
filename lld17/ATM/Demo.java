package ATM;

import ATM.RoomComponents.ATMRoom;
import ATM.Enums.TransactionType;

public class Demo {
    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.getAtm().printCurrentATMStatus();
        atmRoom.getAtm().getCurrentATMState().insertCard(atmRoom.getAtm(), atmRoom.getUser().getCard());
        atmRoom.getAtm().getCurrentATMState().authenticatePin(atmRoom.getAtm(), atmRoom.getUser().getCard(), 112211);
        atmRoom.getAtm().getCurrentATMState().selectOperation(atmRoom.getAtm(), atmRoom.getUser().getCard(),
                TransactionType.CASH_WITHDRAWAL);
        atmRoom.getAtm().getCurrentATMState().cashWithdrawal(atmRoom.getAtm(), atmRoom.getUser().getCard(), 2700);
        atmRoom.getAtm().printCurrentATMStatus();
    }
}