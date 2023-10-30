package gb.javacore.dz4.task2;

public class Order {
    private static int countOrders = 0;
    private Buyer buyer;
    private Product product;
    private int amount;

    public Order(Buyer buyer, Product product, int amount) {
        this.buyer = buyer;
        this.product = product;
        this.amount = amount;
        ++countOrders;
    }

    public static int getCountOrders() {
        return countOrders;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }
}
