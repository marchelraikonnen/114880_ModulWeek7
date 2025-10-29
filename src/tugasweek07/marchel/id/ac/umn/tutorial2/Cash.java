package tugasweek07.marchel.id.ac.umn.tutorial2;

import java.util.Scanner;

public class Cash extends Payment {
    public Cash(Item item) {
        super(item);
    }

    public int pay() {
        if (isPaidOff) {
            return 0;
        }
        isPaidOff = true;
        return this.item.getPrice();
    }

    public String getClassName() {
        return "CASH";
    }
}
