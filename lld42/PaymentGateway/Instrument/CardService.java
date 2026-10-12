package PaymentGateway.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService {

    public CardService() {
        super();
    }

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        CardInstrument cardInstrument = new CardInstrument();

        cardInstrument.instrumentId = new Random().nextInt(100 - 10) + 10;
        cardInstrument.cardNumber = instrumentDO.cardNumber;
        cardInstrument.cvv = instrumentDO.cvvNumber;
        cardInstrument.instrumentType = InstrumentType.CARD;
        cardInstrument.userId = instrumentDO.userId;

        List<Instrument> userInstrumentsList = userVsInstruments.get(cardInstrument.userId);

        if (userInstrumentsList == null) {
            userInstrumentsList = new ArrayList<>();
            userVsInstruments.put(cardInstrument.userId, userInstrumentsList);
        }

        userInstrumentsList.add(cardInstrument);

        return mapBankInstrumentToInstrumentDO((CardInstrument) cardInstrument);
    }

    private InstrumentDO mapBankInstrumentToInstrumentDO(CardInstrument cardInstrument) {
        InstrumentDO instrumentDO = new InstrumentDO();

        instrumentDO.instrumentType = cardInstrument.instrumentType;
        instrumentDO.instrumentId = cardInstrument.instrumentId;
        instrumentDO.cardNumber = cardInstrument.cardNumber;
        instrumentDO.cvvNumber = cardInstrument.cvv;
        instrumentDO.userId = cardInstrument.userId;

        return instrumentDO;
    }

    @Override
    public List<InstrumentDO> getInstrumentByUserId(int userId) {
        List<Instrument> userInstruments = userVsInstruments.get(userId);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();

        for (Instrument instrument : userInstruments) {
            if (instrument.getInstrumentType() == InstrumentType.CARD)
                userInstrumentsFetched.add(mapBankInstrumentToInstrumentDO((CardInstrument) instrument));
        }

        return userInstrumentsFetched;
    }
}