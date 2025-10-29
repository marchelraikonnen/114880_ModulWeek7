package tugasweek07.marchel.id.ac.umn.assigment;

public class Cash extends Payment {
    public Cash(Item item) {
        super(item);
    }

    @Override
    public int pay() {
        if (isPaidOff) {
            return 0;
        }
        isPaidOff = true;
        return this.item.getPrice();
    }

    @Override
    public String getClassName() {
        return "CASH";
    }
}

