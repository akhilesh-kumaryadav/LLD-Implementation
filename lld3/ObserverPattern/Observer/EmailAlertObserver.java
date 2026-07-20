package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservableI;

public class EmailAlertObserver implements NotificationAlertObserverI {
    String emailId;
    StocksObservableI observable;

    // Constructor Injection.
    public EmailAlertObserver(String emailId, StocksObservableI observable) {
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendMail(emailId, "Product is in the stock, hurry up!!!");
    }

    private void sendMail(String emailId, String message) {
        System.out.println("Mail sent to: " + emailId + "that " + message);
    }
}