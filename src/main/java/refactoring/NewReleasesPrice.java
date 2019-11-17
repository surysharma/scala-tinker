package java.refactoring;

public class NewReleasesPrice implements Price {

    @Override
    public int getPriceCode() {
        return 0;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterCharge(int daysRented) {
        if (daysRented> 1) {
            return  1;
        }else return  0;
    }
}
