package ObserverPattern;

import ObserverPattern.Observable.StocksObservableI;
import ObserverPattern.Observable.IphoneObservable;

import ObserverPattern.Observer.NotificationAlertObserverI;
import ObserverPattern.Observer.EmailAlertObserver;
import ObserverPattern.Observer.MobileAlertObserver;

public class Store {
    public static void main(String args[]) {
        StocksObservableI iphoneStockObservable = new IphoneObservable();

        NotificationAlertObserverI observer1 = new EmailAlertObserver("email1@gmail.com", iphoneStockObservable);
        NotificationAlertObserverI observer2 = new EmailAlertObserver("email2@gmail.com", iphoneStockObservable);
        NotificationAlertObserverI observer3 = new MobileAlertObserver("mobile1", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(10);
    }
}