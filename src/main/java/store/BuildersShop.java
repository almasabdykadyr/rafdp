package store;

import data.Publisher;
import data.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BuildersShop implements Store, Publisher {

    private final ArrayList<Product> productsList = new ArrayList<>();
    private final HashMap<ProductType, HashSet<Subscriber>> subscribers = new HashMap<>();

    @Override
    public void addSubscriber(Subscriber subscriber, ProductType notifyProductType) {
        HashSet<Subscriber> oldSubscribers = subscribers.get(notifyProductType);

        if (oldSubscribers != null) {
            oldSubscribers.add(subscriber);
            subscribers.put(notifyProductType, oldSubscribers);
        } else {
            HashSet<Subscriber> emptyOldSubscribers = new HashSet<>();
            subscribers.put(notifyProductType, emptyOldSubscribers);
        }
    }

    @Override
    public void removeSubscriber(Subscriber subscriber, ProductType notifyProductType) {
        subscribers.get(notifyProductType).remove(subscriber);
    }

    @Override
    public void newDelivery(Product... products) {
        for (Product product : products) {
            registerProduct(product);
            notifySubscribers(product.getType());
        }
    }

    private void registerProduct(Product newProduct) {
        productsList.add(newProduct);
    }

    private void notifySubscribers(ProductType productType) {
        HashSet<Subscriber> existingSubscribers = subscribers.get(productType);

        if (existingSubscribers == null) return;

        for (Subscriber subscriber : existingSubscribers) {
            subscriber.update();
        }
    }
}
