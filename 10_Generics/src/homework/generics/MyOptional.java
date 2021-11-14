package homework.generics;

public class MyOptional<T> {
    private T value;
    private MyOptional<T> optional;
    private static MyOptional nullOptional;

    static <T> MyOptional<T> of(T value) {
        if (nullOptional == null) {
            nullOptional = new MyOptional();
        }
        if (value == null) {
            throw new InvalidParameterException();
        }
        MyOptional<T> newMyOptional = new MyOptional<>();
        newMyOptional.value = value;
        return newMyOptional;
    }

    static <T> MyOptional ofNullable(T value) {
        if (nullOptional == null) {
            nullOptional = new MyOptional();
        }
        if (value == null) {
            return MyOptional.nullOptional;
        }
        MyOptional<T> newMyOptional = new MyOptional<>();
        newMyOptional.value = value;
        return newMyOptional;
    }

    public T get() {
        return value;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public T orElse(T other) {
        return this.value == null ? other : (T) value;
    }
}
