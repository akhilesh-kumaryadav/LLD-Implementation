package ObserverPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import ObserverPattern.Observable.StocksObservableI;
import ObserverPattern.Observer.NotificationAlertObserverI;

public class IphoneObservable implements StocksObservableI {
    public List<NotificationAlertObserverI> observersList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserverI observer) {
        observersList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserverI observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserverI observer : observersList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        System.out.println(newStockCount);
        if (stockCount == 0) {
            notifySubscribers();
        }

        if (newStockCount == 0) {
            stockCount = newStockCount;
        } else {
            stockCount += newStockCount;
        }
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

}