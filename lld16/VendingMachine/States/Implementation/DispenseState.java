package VendingMachine.States.Implementation;

import VendingMachine.Context.Item;
import VendingMachine.Context.VendingMachine;
import VendingMachine.States.State;

public class DispenseState extends State {
    DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently Vending Machine is in Dispense State");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }
}
