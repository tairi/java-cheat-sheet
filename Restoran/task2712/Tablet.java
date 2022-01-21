package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number; //индивидуальный номер планшета
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;  //инициализация номера планшета переданным параметром
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this); //создали заказ
            if (order.isEmpty()) {
                return null;
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            advertisementManager.processVideos();
            setChanged();  //установили флаг
            notifyObservers(order);  //отправили заказ повару
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }

    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}

/*

/**/