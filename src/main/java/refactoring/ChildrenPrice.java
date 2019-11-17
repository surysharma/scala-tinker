package java.refactoring;

public class ChildrenPrice implements Price {

    @Override
    public int getPriceCode() {
        return 0;
    }

    @Override
    public double getCharge(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterCharge(int daysRented) {
        return 0;
    }

}
