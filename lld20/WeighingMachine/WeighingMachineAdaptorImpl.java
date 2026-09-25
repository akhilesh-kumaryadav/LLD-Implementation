package WeighingMachine;

// Concreate Adaptor converts pounds -> kg
public class WeighingMachineAdaptorImpl implements WeighingMachineAdaptor {
    // Adaptee Reference
    ImperialWeighingMachine imperialWeighingMachine;

    public WeighingMachineAdaptorImpl(ImperialWeighingMachine weightMachineInPounds) {
        this.imperialWeighingMachine = weightMachineInPounds;
    }

    @Override
    public double getWeightInKG() {
        double weightInPound = imperialWeighingMachine.getWeightInPounds();

        // Conversion formula: 1 pound = 0.453592 Kg
        return weightInPound * 0.45;
    }
}