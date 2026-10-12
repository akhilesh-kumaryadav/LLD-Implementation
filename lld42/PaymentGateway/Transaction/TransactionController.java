package PaymentGateway.Transaction;

import java.util.List;

public class TransactionController {
    TransactionService txnService;

    public TransactionController() {
        this.txnService = new TransactionService();
    }

    public TransactionDO makePayment(TransactionDO txnDO) {
        return txnService.makePayment(txnDO);
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return txnService.getTransactionHistory(userId);
    }
}
