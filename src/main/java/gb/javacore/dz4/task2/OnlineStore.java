package gb.javacore.dz4.task2;

public class OnlineStore {
    private static final Buyer[] buyers = {
            new Buyer("Иван", "1@mail.ru", "+79001111111"),
            new Buyer("Павел", "2@mail.ru", "+79002222222"),
            new Buyer("Сергей", "3@mail.ru", "+79003333333")
    };
    private static final Product[] products = {
            new Product("Чайник", 1999),
            new Product("Тостер", 2590),
            new Product("Пылесос", 6990),
            new Product("Телевизор", 20990),
            new Product("Духовой шкаф", 35990),
            new Product("Холодильник", 84990)
    };
    private static Order[] orders = new Order[7];

    public static Order makePurchase(Buyer buyer, Product product, int amount) throws StoreExseption {
        if (notContainsInArray(buyers, buyer))
            throw new BuyerException("Покупатель '" + buyer.getName() + "' не зарегистрирован");
        if (notContainsInArray(products, product))
            throw new ProductException("Товар '" + product.getName() + "' не найден");
        if (amount < 0)
            throw new AmountException("Количество товара в заказе не может быть отрицательным");
        return new Order(buyer, product, amount);
    }

    private static boolean notContainsInArray(Object[] array, Object object) {
        for (Object o : array) {
            if (o.equals(object))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        class Sample {         // Локальный внутренний класс для размещения тестовых данных
            final Buyer buyer;
            final Product product;
            final int amount;

            public Sample(Buyer buyer, Product product, int amount) {
                this.buyer = buyer;
                this.product = product;
                this.amount = amount;
            }
        }
        Sample[] samples = {   // Массив тестовых данных для дальнейшей их передачи в метод совершения покупки
                new Sample(buyers[0], products[0], 2),
                new Sample(buyers[1], products[1], -2),
                new Sample(buyers[2], products[2], 1),
                new Sample(new Buyer("Игорь", "4@mail.ru", "+79004444444"), products[3], 1),
                new Sample(buyers[0], new Product("Хлеб", 40), 5),
                new Sample(buyers[1], products[4], 1),
                new Sample(buyers[2], products[5], 1),

        };

        int i = 0;
        for (Sample sample : samples) {
            try {
                orders[i] = makePurchase(sample.buyer, sample.product, sample.amount);
                i++;
            } catch (StoreExseption e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nКоличество совершённых покупок: " + Order.getCountOrders());
    }
}
