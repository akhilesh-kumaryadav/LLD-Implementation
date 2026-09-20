package ATM.AmountWithdrawal;

import ATM.RoomComponents.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nexCashWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        this.nexCashWithdrawProcessor = cashWithdrawProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount) {
        if (nexCashWithdrawProcessor != null) {
            nexCashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }
}