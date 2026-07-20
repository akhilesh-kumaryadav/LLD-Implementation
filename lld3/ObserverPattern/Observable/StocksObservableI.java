package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserverI;

public interface StocksObservableI {
    public void add(NotificationAlertObserverI observer);

    public void remove(NotificationAlertObserverI observer);

    public void notifySubscribers();

    public void setStockCount(int newStockCount);

    public int getStockCount();
}