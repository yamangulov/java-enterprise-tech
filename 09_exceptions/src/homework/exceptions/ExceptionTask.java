package homework.exceptions;

import java.util.Objects;
import java.util.Optional;

public class ExceptionTask {

    public static Optional<String> mergeStrings(String first, String second) {
        if ((first == null && second == null) || (Objects.equals(first, "") && Objects.equals(second, ""))) {
            return Optional.empty();
        } else {
            String frst = Optional.of(first != null ? first : "").get();
            String scnd = Optional.of(second != null ? second : "").get();
            return Optional.of(frst.length() > scnd.length() ? frst + scnd : scnd + frst);
        }
    }

    public static long getPower(int n, int p) {
        if (n < 0 || p < 0) {
            return -1L;
        } else if (n == 0) {
            return -1L;
        } else {
            return (long) (Math.pow(n, p));
        }
    }

    public static void customException(int a) throws InvalidZeroParameterException {
        if (a == 0) {
            throw new InvalidZeroParameterException();
        } else {
            try {
                throwUncheckedException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void exceptionProcessing() {
        try {
            throwCheckedException();
            throwUncheckedException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void throwCheckedException() throws Exception {
        throw new Exception("Checked exception");
    }

    private static void throwUncheckedException() {
        throw new RuntimeException("Unchecked exception");
    }
}
