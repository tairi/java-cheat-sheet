package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static com.javarush.task.task27.task2712.ad.AdvertisementStorage.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = getInstance();

    private int timeSeconds; // время приготовления заказа
    private long maxAmount; //масксимальная стоимость рекламы
    private List<Advertisement> optimalVideoSet; // оптимальный список видео
    private int totalTimeSecondsLeft; //количество оставшихся секунд

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        this.totalTimeSecondsLeft = Integer.MAX_VALUE; //задали максимальное время
        createOptimalVideoSet();
        displayAdvertisement();

        /*
        1. Сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов.
2. Общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа.
3. Для одного заказа любой видео-ролик должен показываться не более одного раза.

???  4. Если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов,
то должен быть выбран вариант с максимальным суммарным временем.


5. Если существует несколько вариантов набора видео-роликов с одинаковой суммой денег и одинаковым суммарным
временем, то должен быть выбран вариант с минимальным количеством роликов.

6. В набор должны отбираться только ролики с положительным числом показов.
*/
    }

    private List<Advertisement> createOptimalVideoSet () {
        totalTimeSecondsLeft = timeSeconds;
        optimalVideoSet = new LinkedList();
       // LinkedList<Advertisement> reservVideo = new LinkedList<>();

        // почему не получается влезть в видео из списка?
        for (Advertisement video : storage.list()) {
            if (video.isActive()) { //проверили есть ли оплаченные показы, если да, то
                if (totalTimeSecondsLeft >= video.getDuration()) { //проверили, влезает ли в остаток времени, если да, то
                    for (Advertisement oV : optimalVideoSet) { //проверили наличие в оптимальном списке
                        if (video.getName().equals(oV.getName())) {//если да, то
                            break;   //зевершили цикл (можно ли написать как-то по-другому пропуск видео? Чтобы продолжить проверку дальше по стартовому списку
                            //  reservVideo.add(video); //можно добавить в левый список, чтобы проверить после окончания проверки полного списка, если totalTimeSecondsLeft > 0
                        } else {  //иначе
                            optimalVideoSet.add(video);  //добавили видео в оптимальный список
                            totalTimeSecondsLeft = totalTimeSecondsLeft - video.getDuration();
                        }  //отредактировали оставшееся время
                    }
                }
            }
        }

        return optimalVideoSet;
    }


    private void displayAdvertisement() throws NoVideoAvailableException {

        //отсекаем ошибки по пустому списку видео
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        // пишем сортировщик по деньгам и по продолжительности:
        optimalVideoSet.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying(); //сортировка по времени по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());  //сортировка по длительности ролика по увеличению
        });

        for (Advertisement ad : optimalVideoSet) {
            displayInPlayer(ad); // вывели строку списка на экран
            ad.revalidate(); // 7. Для каждого показанного ролика должен быть вызван метод revalidate.
        }
    }

    // Вывод на экран результатов сортировки - список оптимальных видеороликов
    private void displayInPlayer(Advertisement advertisement) {
        System.out.println(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() +
                ", " + (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
    }
}

/*
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду.
(Пока делать не нужно, сделаем позже).
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа
одного рекламного ролика в копейках. Вторичная сортировка - по увеличению стоимости показа одной
секунды рекламного ролика в тысячных частях копейки.
Используй метод Collections.sort

Пример для заказа [WATER]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используй методы из класса Advertisement.*/