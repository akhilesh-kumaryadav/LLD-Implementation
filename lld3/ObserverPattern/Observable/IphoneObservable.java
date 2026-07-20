import java.util.ArrayList;
import java.util.List;

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
    public notifySubscribers(){
        for(NotificationAlertObserverI observer: observersList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0) {
            notifySubscribers();
        }

        stockCount += newStockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

}