package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdvertisementStorage {
    //хранилище рекламных роликов
    private static class InstanseHolder {
        private static final AdvertisementStorage ourInstance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return InstanseHolder.ourInstance;
    }

    private final List<Advertisement> videos = new LinkedList<>();

    private AdvertisementStorage() {
        //init random videos
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min

        //вот это нововведение
        videos.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDispleyingThousandKopecks() - o1.getAmountPerOneDispleyingThousandKopecks(); //сортировка по времени по увеличению стоимости показа одной секунды рекламного ролика в копейках
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());  //сортировка по длительности ролика по увеличению
        });
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
