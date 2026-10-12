package PaymentGateway.Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService {
    public BankService() {
        super();
    }

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentId = new Random().nextInt(100 - 10) + 10;
        bankInstrument.bankAccountNumber = instrumentDO.bankAccountNumber;
        bankInstrument.ifscCode = instrumentDO.ifsc;
        bankInstrument.instrumentType = InstrumentType.BANK;
        bankInstrument.userId = instrumentDO.userId;

        List<Instrument> userInstrumentList = userVsInstruments.get(bankInstrument.userId);

        if (userInstrumentList == null) {
            userInstrumentList = new ArrayList<>();
            userVsInstruments.put(bankInstrument.userId, userInstrumentList);
        }

        userInstrumentList.add(bankInstrument);

        return mapBankInstrumentToInstrumentDO(bankInstrument);
    }

    @Override
    public List<InstrumentDO> getInstrumentByUserId(int userId) {
        List<Instrument> userInstruments = userVsInstruments.get(userId);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();

        for (Instrument instrument : userInstruments) {
            if (instrument.getInstrumentType() == InstrumentType.BANK) {
                userInstrumentsFetched.add(mapBankInstrumentToInstrumentDO((BankInstrument) instrument));
            }
        }

        return userInstrumentsFetched;
    }

    public InstrumentDO mapBankInstrumentToInstrumentDO(BankInstrument bankInstrument) {
        InstrumentDO instrumentDO = new InstrumentDO();

        instrumentDO.instrumentType = bankInstrument.instrumentType;
        instrumentDO.instrumentId = bankInstrument.instrumentId;
        instrumentDO.bankAccountNumber = bankInstrument.bankAccountNumber;
        instrumentDO.ifsc = bankInstrument.ifscCode;
        instrumentDO.userId = bankInstrument.userId;

        return instrumentDO;
    }
}