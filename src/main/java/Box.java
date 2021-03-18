public final class Box<T> {
    private T element;

    public T get() {
        return element;
    }

    public void put(final T el) {
        element = el;
    }

    @Override
    public String toString() {
        return "Box{"
                + "element="
                + element
                + '}';
    }
}
