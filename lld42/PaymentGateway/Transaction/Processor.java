package PaymentGateway.Transaction;

import PaymentGateway.Instrument.InstrumentDO;

public class Processor {

    public void processPayment(InstrumentDO senderInstrumentDO, InstrumentDO receiverInstrumentDO) {

        // validate sender instrument

        // validate receiver instrument

        // process payment

        // update balance in sender instrument - debit

        // update balance in receiver instrument - credit

    }
}
