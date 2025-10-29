package tugasweek07.marchel.id.ac.umn.tutorial1;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract void processPayment();

    public void paymentDetails() {
        System.out.println("Processing payment of $" + amount);
    }
}
