package WeighingMachine;

public class ImperialWeighingMachineImpl implements ImperialWeighingMachine {
    double weightInPounds = 0;

    public ImperialWeighingMachineImpl(double weighingScaleReading) {
        this.weightInPounds = weighingScaleReading;
    }

    // Third-party weighing machine (US Model) - returns pounds
    @Override
    public double getWeightInPounds() {
        return weightInPounds;
    }
}