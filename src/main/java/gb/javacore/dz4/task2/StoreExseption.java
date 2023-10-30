package gb.javacore.dz4.task2;

public class StoreExseption extends Exception {
    public StoreExseption(String message) {
        super("Ошибка! " + message);
    }
}

class BuyerException extends StoreExseption {
    public BuyerException(String message) {
        super(message);
    }
}

class ProductException extends StoreExseption {
    public ProductException(String message) {
        super(message);
    }
}

class AmountException extends StoreExseption {
    public AmountException(String message) {
        super(message);
    }
}
