package PaymentGateway.Transaction;

import PaymentGateway.Instrument.InstrumentController;
import PaymentGateway.Instrument.InstrumentDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {

    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return userVsTransactionsList.get(userId);
    }

    public TransactionDO makePayment(TransactionDO txnDO) {
        // validate details

        // load sender instrument details which need to be passed to processors
        InstrumentDO senderInstrumentDO = instrumentController.getInstrumentById(txnDO.getSenderId(),
                txnDO.getDebitInstrumentId());

        // load receiver instrument details which need to be passed to processors
        InstrumentDO receiverInstrumentDO = instrumentController.getInstrumentById(txnDO.getReceiverId(),
                txnDO.getCreditInstrumentId());

        // pass the instrument details to processor
        processor.processPayment(senderInstrumentDO, receiverInstrumentDO);

        // based on processor response, we will set the status. for now har coding it to
        // SUCCESS
        Transaction txn = new Transaction();
        txn.setAmount(txnDO.getAmount());
        txn.setTxnId(txnDO.getTxnId());
        txn.setSenderId(txnDO.getSenderId());
        txn.setReceiverId(txnDO.getReceiverId());
        txn.setDebitInstrumentId(txnDO.getDebitInstrumentId());
        txn.setCreditInstrumentId(txnDO.getCreditInstrumentId());
        txn.setStatus(TransactionStatus.SUCCESS);

        // history
        List<Transaction> senderTxnsList = userVsTransactionsList.get(txn.getSenderId());
        if (senderTxnsList == null) {
            senderTxnsList = new ArrayList<>();
            userVsTransactionsList.put(txn.getSenderId(), senderTxnsList);
        }
        senderTxnsList.add(txn);

        List<Transaction> receiverTxnLists = userVsTransactionsList.get(txn.getReceiverId());
        if (receiverTxnLists == null) {
            receiverTxnLists = new ArrayList<>();
            userVsTransactionsList.put(txn.getReceiverId(), receiverTxnLists);
        }
        receiverTxnLists.add(txn);

        txnDO.setTxnId(txn.getTxnId());
        txnDO.setStatus(txn.getStatus());

        return txnDO;
    }
}
