package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservableI;

public class MobileAlertObserver implements NotificationAlertObserverI {
    String userName;
    StocksObservableI observable;

    // Constructor Injection.
    public MobileAlertObserver(String userName, StocksObservableI observable) {
        this.observable = observable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendMessage(emailId, "Product is in the stock, hurry up!!!");
    }

    private void sendMessage(String userName, String message) {
        System.out.println("SMS sent to: " + userName + "that " + message);
    }
}