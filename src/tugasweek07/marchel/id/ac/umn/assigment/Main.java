package tugasweek07.marchel.id.ac.umn.assigment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Item> ListOfItems = new ArrayList<Item>();
    static ArrayList<Payment> ListOfPayments = new ArrayList<Payment>();
    static Scanner s = new Scanner(System.in);

    public static void seedData() {
        ListOfItems.add(new Item("Kulkas", "Electronic", 4800000));
        ListOfItems.add(new Item("TV", "Electronic", 1280000));
        ListOfItems.add(new Item("Laptop", "Computer", 6000000));
        ListOfItems.add(new Item("PC", "Computer", 12000000));
    }

    public static void printItem(Item item) {
        System.out.println("Nama  : " + item.getName());
        System.out.println("Tipe  : " + item.getType());
        System.out.println("Harga : " + item.getPrice());
    }

    public static void printMenu() {
        System.out.println("---Program Toko Elektronik---");
        System.out.println("1. Pesan Barang");
        System.out.println("2. Lihat Pesanan");
        System.out.println("0. Keluar");
        System.out.print("Pilih : ");
    }

    public static void menuPesan() {
        System.out.println("----Daftar Barang----");
        for (int i = 0; i < ListOfItems.size(); i++) {
            System.out.println("No  : " + (i + 1));
            printItem(ListOfItems.get(i));
            System.out.println("-----------------------------");
        }
        System.out.print("Pilih : ");
        int pilih = s.nextInt();
        if (pilih < 1 || pilih > ListOfItems.size()) {
            System.out.println("Pilihan tidak valid");
            return;
        }
        Item selected = ListOfItems.get(pilih - 1);
        printItem(selected);
        System.out.println("----Tipe pembayaran----");
        System.out.println("1. Cash");
        System.out.println("2. Credit");
        System.out.print("Pilih : ");
        int tipe = s.nextInt();
        if (tipe == 1) {
            Cash c = new Cash(selected);
            ListOfPayments.add(c);
            System.out.print("Bayar (Y/N): ");
            String yn = s.next();
            if (yn.equalsIgnoreCase("Y")) {
                int paid = c.pay();
                System.out.println("Harga Pembayaran : " + selected.getPrice());
                System.out.println("Bayar : " + paid);
                System.out.println("Transaksi telah dibayar lunas");
            } else {
                System.out.println("Transaksi telah disimpan");
            }
        } else if (tipe == 2) {
            Credit cr = new Credit(selected);
            ListOfPayments.add(cr);
            cr.pay();
        } else {
            System.out.println("Pilihan pembayaran tidak valid");
        }
    }

    public static void menuLihatPesanan() {
        if (ListOfPayments.isEmpty()) {
            System.out.println("Belum ada pesanan");
            return;
        }
        for (int i = 0; i < ListOfPayments.size(); i++) {
            Payment p = ListOfPayments.get(i);
            System.out.println("No  : " + (i + 1));
            System.out.println("Nama  : " + p.getItemName());
            System.out.println("Tipe  : " + p.getItem().getType());
            System.out.println("Status: " + p.getStatus());
            System.out.println("Sisa Pembayaran : " + p.getRemainingAmount());
            System.out.println("-----------------------------");
        }
        System.out.print("Pilih No Transaksi : ");
        int id = s.nextInt();
        if (id < 1 || id > ListOfPayments.size()) {
            System.out.println("Pilihan tidak valid");
            return;
        }
        Payment chosen = ListOfPayments.get(id - 1);
        System.out.println("Nama  : " + chosen.getItemName());
        System.out.println("Tipe  : " + chosen.getItem().getType());
        System.out.println("Status: " + chosen.getStatus());
        System.out.println("Sisa Pembayaran : " + chosen.getRemainingAmount());
        if (!chosen.isPaidOff()) {
            System.out.print("Lakukan pembayaran sekarang? (Y/N): ");
            String yn = s.next();
            if (yn.equalsIgnoreCase("Y")) {
                chosen.pay();
            }
        } else {
            System.out.println("Transaksi telah lunas");
        }
    }

    public static void main(String[] args) {
        seedData();
        int opt;
        do {
            printMenu();
            opt = s.nextInt();
            if (opt == 1) {
                menuPesan();
            } else if (opt == 2) {
                menuLihatPesanan();
            } else if (opt == 0) {
                System.out.println("Terima Kasih");
            } else {
                System.out.println("Salah Input");
            }
        } while (opt != 0);
    }
}

