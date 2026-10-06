package BridgePattern.Solution;

// Step 4 - Refined Abstraction (Concrete LivingThings)
public class Dog extends LivingThings {
    public Dog(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breathe() {
        System.out.println("Dog: ");

        // Operation implemented by Implementor - defines the "HOW"
        breathingProcess.breathe();
    }
}