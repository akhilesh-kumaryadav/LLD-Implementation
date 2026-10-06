package BridgePattern.Solution;

// Step2 - Concraete Implementor (various breathing processes)
public class LungBreathing implements BreathingProcess {
    @Override
    public void breathe() {
        System.out.println("Breathing through lungs.");
    }
}