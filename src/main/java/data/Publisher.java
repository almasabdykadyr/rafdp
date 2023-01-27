package data;

import store.ProductType;

public interface Publisher {
    void addSubscriber(Subscriber subscriber, ProductType notifyProductType);

    void removeSubscriber(Subscriber subscriber, ProductType notifyProductType);
}
