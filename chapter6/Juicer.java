package chapter6;

public class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> fruitBox){
        String tmp = "";
        for(Fruit f : fruitBox.getList()){
            tmp += f+" ";
        }
        return new Juice(tmp);
    }
}
