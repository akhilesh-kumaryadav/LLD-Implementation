package PaymentGateway.Instrument;

public class InstrumentServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType) {
        System.out.println(instrumentType);
        if (instrumentType == InstrumentType.BANK)
            return new BankService();
        else if (instrumentType == InstrumentType.CARD)
            return new CardService();

        return null;
    }
}