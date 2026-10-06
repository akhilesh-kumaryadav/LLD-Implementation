package BridgePattern.Solution;

// Step 4 - Refined Abstraction (Concrete LivingThings)
public class Tree extends LivingThings {
    public Tree(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breathe() {
        System.out.println("Tree: ");

        // Operation implemented by Implementor - defines the "HOW"
        breathingProcess.breathe();
    }
}