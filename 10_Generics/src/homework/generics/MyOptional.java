package homework.generics;

public class MyOptional {
    private static Object value;
    private static MyOptional optional;

    static <T> MyOptional of(T value) {
        if (optional == null) {
            optional = new MyOptional();
        }
        if (value == null) {
            throw new InvalidParameterException();
        }
        MyOptional.value = value;
        return optional;
    }

    static <T> MyOptional ofNullable(T value) {
        if (optional == null) {
            optional = new MyOptional();
        }
        if (value == null) {
            MyOptional.value = null;
            return optional;
        }
        MyOptional.value = value;
        return optional;
    }

    @SuppressWarnings("unchecked")
    public <T> T get() {
        return (T) value;
    }

    public boolean isPresent() {
        return MyOptional.value != null;
    }

    @SuppressWarnings("unchecked")
    public <T> T orElse(T other) {
        return MyOptional.value == null ? other : (T) value;
    }
}
