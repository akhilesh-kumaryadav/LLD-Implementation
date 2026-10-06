package BridgePattern.Solution;

// Step 4 - Refined Abstraction (Concrete LivingThings)
public class Fish extends LivingThings {
    public Fish(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breathe() {
        System.out.println("Fish: ");

        // Operation implemented by Implementor - defines the "HOW"
        breathingProcess.breathe();
    }
}