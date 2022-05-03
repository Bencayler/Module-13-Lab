package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A Warehouse receives, stores and ships Items.
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Warehouse
{
    /**
     * storage is managed as one big stack, where items are laid on top of each other
     */
    private ArrayList<Item> storage = new ArrayList<Item>();

    public int getNumberOfItemsInStock()
    {
        // TODO: return the number of items in storage
        return storage.size();

    }

    /**
     * TODO Modify to add item to the collection and make the tests pass.
     *
     * @param item the item to store in the Warehouse
     */
    public void receive(Item item)
    {
        //System.out.println("Warehouse receive(" + item + ") running in Thread: " + Thread.currentThread().getName());

        // TODO: store item at the front of the list
        synchronized (storage)
        {
            storage.add(item);
        }

    }

    /**
     * TODO Modify to remove an item from the collection and make the tests pass
     * @return the item that was retrieved from storage
     * @throws OutOfStockException if there are no items to ship
     */
    public Item ship() throws OutOfStockException {
        System.out.println("Warehouse ship() running in Thread: " + Thread.currentThread().getName());

        // TODO: return the first item in the list,
        // if there are any items in storage
        synchronized (storage) {

            if (storage.size() >= 1) {
                return storage.remove(storage.size() - 1);
            } else
                throw new OutOfStockException();
        }
    }

}