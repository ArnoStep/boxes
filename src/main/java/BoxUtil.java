public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        dest.put(src.get());
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        try {
            if (src.get().isFresh()) {
                dest.put(src.get());
            }
        } catch (NullPointerException e) {
            System.out.println("В коробке пусто!");
        }
    }

    //вывести в консоль (toString()) объект второй коробки
    public static <T> void printElementFromTwoBoxes(final Box<Box<T>> box) {
        System.out.println(box.get().get().toString());
    }

    /**
     * вывести в консоль (toString()) объект последней коробки
     * <p>
     * box Box, которая содержит в себе любое кол-во вложенных Box, в последней из которых может быть любой объект.
     */
    public static <T> void printElementFromBoxes(Box<T> box) {
        while (box.get() instanceof Box) {
            box = (Box<T>) box.get(); // unchecked cast, хотя вроде проверяю в строчке выше
        }
        System.out.println(box.get().toString());
    }
}