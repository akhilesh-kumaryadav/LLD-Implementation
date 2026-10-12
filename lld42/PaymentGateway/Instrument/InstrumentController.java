package PaymentGateway.Instrument;

import java.util.List;

public class InstrumentController {

    InstrumentServiceFactory instrumentControllerFactory;

    public InstrumentController() {
        this.instrumentControllerFactory = new InstrumentServiceFactory();
    }

    public InstrumentDO addInstrument(InstrumentDO instrument) {
        InstrumentService instrumentController = instrumentControllerFactory
                .getInstrumentService(instrument.instrumentType);
        return instrumentController.addInstrument(instrument);
    }

    public List<InstrumentDO> getAllInstruments(int userId) {
        InstrumentService bankInstrumentController = instrumentControllerFactory
                .getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentController = instrumentControllerFactory
                .getInstrumentService(InstrumentType.CARD);
        List<InstrumentDO> instrumentDOList = bankInstrumentController.getInstrumentByUserId(userId);
        instrumentDOList.addAll(cardInstrumentController.getInstrumentByUserId(userId));
        return instrumentDOList;
    }

    public InstrumentDO getInstrumentById(int userId, int instrumentId) {
        List<InstrumentDO> instrumentDOList = getAllInstruments(userId);

        for (InstrumentDO instrumentDO : instrumentDOList) {
            if (instrumentDO.getInstrumentId() == instrumentId) {
                return instrumentDO;
            }
        }
        return null;
    }
}
