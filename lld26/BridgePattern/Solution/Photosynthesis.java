package BridgePattern.Solution;

// Step2 - Concraete Implementor (various breathing processes)
public class Photosynthesis implements BreathingProcess {
    @Override
    public void breathe() {
        System.out.println("Breathing through process of photosynthesis. Releases Oxygen through leaves.");
    }
}