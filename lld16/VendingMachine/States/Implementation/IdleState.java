package VendingMachine.States.Implementation;

import java.util.ArrayList;

import VendingMachine.Context.Item;
import VendingMachine.Context.VendingMachine;
import VendingMachine.States.State;

public class IdleState extends State {
    public IdleState() {
        System.out.println("Currently Vending Machine is in IdleState");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently Vending Machine is in Idle State");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}