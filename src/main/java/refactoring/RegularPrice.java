package java.refactoring;

public class RegularPrice implements Price {

    @Override
    public int getPriceCode() {
        return 0;
    }

    @Override
    public double getCharge(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterCharge(int daysRented) {
        return 0;
    }
}
