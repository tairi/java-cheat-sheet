package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать статический класс Word.
3. Класс Solution не должен содержать статические поля.
4. Метод detectAllWords должен быть статическим.
5. Метод detectAllWords должен быть публичным.
6. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();
        int hor = crossword[0].length; //определили размер массива горизонталь
        int ver = crossword.length; //определили размер массива вертикаль

        for (String word : words) { //взяли слово из списка
            wordList.add(detectedWorld(crossword, word)); //добавили в список слово из кроссворда
        }

        return wordList;
    }

    public static Word detectedWorld (int[][] crossword, String word) {  //пишем сам поиск слова
        String[] symbols = word.split(""); //разбили слово на символы
        //1. поиск первого символа
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                int symbol = crossword[i][j];
                if (symbols[0].charAt(0) == symbol) { // если i j символ равен первому символу слова...
                    //запоминаем начальные координаты
                    int x1 = j;
                    int y1 = i;
                    //ищем слово
                    Word fundedWord = null;
                    int[] route = new int[]{1, 0, -1};
                    for (int k = 0; k < route.length; k++) {
                        for (int l = 0; l < route.length; l++) {
                            fundedWord = seekWorld(crossword, word, x1, y1, route[k], route[l]);
                            if (fundedWord != null) 
                                return fundedWord;
                        }
                    }
                }
            }
        }

        return null;
    }

    private static Word seekWorld(int[][] crossword, String word, int x1, int y1, int deltax, int deltay) {
        Word fundedWord = new Word(word);
        fundedWord.setStartPoint(x1, y1);
        //2.Поиск символов от отправной точки
        String[] symbols = word.split("");
        boolean wordFound = false;
        for (String symbol : symbols) {
            //Проверка не выхода за границу
            if (!(y1 >= 0 && crossword.length > y1)) return null;
            if (!(x1 >= 0 && crossword[y1].length > x1)) return null;

            if ((int) symbol.charAt(0) == crossword[y1][x1]) {
                x1 += deltax;
                y1 += deltay;
            } else return null;
        }
        fundedWord.setEndPoint(x1 - deltax, y1 -deltay);//костыль
        return fundedWord;

    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {

            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
