package BridgePattern.Solution;

// Step 3 : Abstraction for LivingThings
public abstract class LivingThings {
    // Reference to Implementor
    protected BreathingProcess breathingProcess;

    // Bridge connects Animal with Breathing
    public LivingThings(BreathingProcess breathingProcess) {
        this.breathingProcess = breathingProcess;
    }

    // Operation implement by Implementor
    abstract public void breathe();
}