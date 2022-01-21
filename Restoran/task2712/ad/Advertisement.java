package com.javarush.task.task27.task2712.ad;

public class Advertisement {  // Рекламное объявление
    private Object content;  // видео
    private String name; // имя/название
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        if (hits > 0) {
            amountPerOneDisplaying = initialAmount / hits; //стоимость одного показа в копейках
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getAmountPerOneDispleyingThousandKopecks () {
        return amountPerOneDisplaying*1000/duration;
    }

    public void revalidate() {
        if (hits == 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    public boolean isActive() {
        return hits > 0;
    }
}
