package ru.tayrinn.secondlessons;

//Класс описывает структуру объектов, относящихся к нему.
// Например - класс "Квадрат" описывает информацию,
//которая будет отличать один квадрат от другого - в частности, длина стороны и название
public class Square {
    //Эти переменные в классе не помечены словом static потому
    // что она может быть разной у разных квадратов
    private int sideLength; //длина стороны
    private String name; //название

    //Это - конструктор.
    // Специальный метод, которым мы создаём описание одного конкретного квадрата
    // по нашей схеме,
    //Пишется он по форме public НазваниеКласса(Данные о новом объекте класса){}
    public Square(int sideLength, String name) {
        this.sideLength = sideLength;
        this.name = name;
    }

    public Square() {
    }

    //Этот метод вернёт в то место, где мы его вызовем, площадь того конкретного квадрата,
    // у которого мы его вызовем.
    //Т.е. описывая этот метод мы учим каждый квадрат считать свою -
    // и только свою - площадь
    public int getSize(){
        System.out.println("Сейчас я, квадрат " + this.name + " посчитаю свою площадь");
        //Возврат данных отмечается специальным словом return - "возврат, возвращение".
        return sideLength * sideLength;
    }

    //Ну и для пущего усложнения картины научим каждый квадрат считать
    // ещё и свой периметр
    public int getPerimeter(){
        System.out.println("Сейчас я, квадрат " + name + " посчитаю свой периметр");
        //Возврат данных отмечается специальным словом return - "возврат, возвращение".
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                ", name='" + name + "\'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        if (sideLength != square.sideLength) return false;
        return name != null ? name.equals(square.name) : square.name == null;
    }

    @Override
    public int hashCode() {
        int result = sideLength;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Square withSide(int side){
        setSideLength(side);
        return this;
    }

    public Square withName(String name){
        setName(name);
        return this;
    }
}
