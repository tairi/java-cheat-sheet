package ru.tayrinn.secondlessons;

public class Home {
    public static void main(String[] args) {
        //А это - уже понятный тебе мейн)

        //Создаём первый квадрат - со сторонами 1 и считающий, что его зовут ABCD
        Square square1 = new Square(1, "ABCD");

        //Создаём второй квадрат - со сторонами 2 и "именем" EFGH
        Square square2 = new Square(2,"EFGH");
        Square square3 = new Square().withName("IJKL").withSide(3);
        //А здесь мы поочерёдно печатаем данные обоих квадратов
        printSquareData(square1);
        printSquareData(square2);
    }

    //Теперь пишем вполне обычный static-метод, который будет печатать какую-нибудь
    // фразу с данными переданного ему
    // в качестве параметра квадрата
    public static void printSquareData(Square square){
        //Здесь наш метод лезет в переданный ему квадрат и спрашивает,
        // какие данные лежат именно в переданном ему квадрате
        System.out.println("Знакомься, это квадрат по имени " + square.getName() + " со стороной " + square.getSideLength());
        //А здесь - обращается к методу конкретного квадрата,
        // прося его посчитать его собственные характеристики
        System.out.println("У квадрата " + square.getName() + " периметр " + square.getPerimeter());
        System.out.println("У квадрата " + square.getName() + " площадь " + square.getSize());
    }
}
