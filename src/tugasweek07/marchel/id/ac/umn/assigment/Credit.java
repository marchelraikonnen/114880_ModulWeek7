package tugasweek07.marchel.id.ac.umn.assigment;

import java.util.Scanner;

public class Credit extends Payment {
    private int remaining;
    private int months;
    private int installmentAmount;

    public Credit(Item item) {
        super(item);
        this.remaining = item.getPrice();
        this.months = 0;
        this.installmentAmount = 0;
    }

    @Override
    public int pay() {
        if (isPaidOff) {
            return 0;
        }
        Scanner s = new Scanner(System.in);
        if (months == 0) {
            System.out.println("----Tipe pembayaran----");
            System.out.println("1. Cash");
            System.out.println("2. Credit");
            System.out.print("Pilih : ");
            int t = s.nextInt();
            if (t != 2) {
                System.out.println("Metode bukan credit");
                return 0;
            }
            System.out.print("Lama Cicilan (3/6/9/12): ");
            months = s.nextInt();
            if (months != 3 && months != 6 && months != 9 && months != 12) {
                months = 3;
            }
            installmentAmount = item.getPrice() / months;
            System.out.println("Lama Cicilan (" + months + "): " + months);
        }
        System.out.println("Harga Pembayaran : " + item.getPrice());
        System.out.println("Sisa Pembayaran : " + remaining);
        System.out.print("Bayar (Y/N): ");
        String yn = s.next();
        if (yn.equalsIgnoreCase("N")) {
            System.out.println("Transaksi telah disimpan");
            return 0;
        }
        System.out.print("Bayar : ");
        int bayar = s.nextInt();
        if (bayar <= 0) {
            System.out.println("Pembayaran tidak valid");
            return 0;
        }
        if (bayar >= remaining) {
            int paid = remaining;
            remaining = 0;
            isPaidOff = true;
            System.out.println("Bayar : " + paid);
            System.out.println("Transaksi telah dibayar lunas");
            return paid;
        } else {
            remaining -= bayar;
            System.out.println("Bayar : " + bayar);
            System.out.println("Sisa Pembayaran : " + remaining);
            return bayar;
        }
    }

    @Override
    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        }
        return remaining;
    }

    @Override
    public String getClassName() {
        return "CREDIT";
    }
}

