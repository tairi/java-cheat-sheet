package ru.tayrinn.firstlessons;

public class CatsCount {
 //   public class Cat {
        private static int catsCount = 0;

        public CatsCount() {
            addNewCat();
        }

        public static void addNewCat() {
            //напишите тут ваш код
            ++catsCount;

        }

        public static void main(String[] args) {
        CatsCount one = new CatsCount();
        CatsCount dwa = new CatsCount();
        CatsCount tri = new CatsCount();
        System.out.println("Количество созданных кошек = " + CatsCount.catsCount);
        }
    }
         /*Реализовать метод addNewCat, чтобы при его вызове (т.е. добавлении нового кота), количество котов увеличивалось на 1.
         За количество котов отвечает переменная catsCount.


         Требования:
         1. Класс Cat должен содержать только одну переменную catsCount.
         2. Переменная catsCount должна быть статической, иметь модификатор доступа private, тип int и проинициализирована нулем.
         3. Класс Cat должен содержать два метода addNewCat и main.
         4. Метод addNewCat класса Cat должен увеличивать количество котов на 1.*/

