package tugasweek07.marchel.id.ac.umn.tutorial1;

public class Main {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment(100.0, "1234-5678-9012-3456");
        Payment bankTransferPayment = new BankTransferPayment(300.0, "9876543210");

        creditCardPayment.paymentDetails();
        creditCardPayment.processPayment();

        bankTransferPayment.paymentDetails();
        bankTransferPayment.processPayment();
    }
}
