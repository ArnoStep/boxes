public class Main {
    public static void main(final String[] args) {
        Fruit fruit = new Fruit();
        fruit.setFresh(false);
        Box<Fruit> box2 = new Box<>();
        box2.put(fruit);
        Box<Box<Fruit>> box1 = new Box<>();
        box1.put(box2);
        Box<Box<Box<Fruit>>> box = new Box<>();
        box.put(box1);
        BoxUtil.printElementFromBoxes(box); // исправно работает

        Box<Apple> srcBox = new Box<>();
        Box<Object> destBox = new Box<>();
        BoxUtil.copyFreshFruitFromBoxToBox(srcBox, destBox);
        System.out.println(destBox.get());

    }
}