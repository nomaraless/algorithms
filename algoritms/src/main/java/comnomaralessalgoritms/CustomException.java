package comnomaralessalgoritms;


import java.util.List;

public class CustomException extends RuntimeException {
    public static <T> T nullException(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        return item;
    }
}
