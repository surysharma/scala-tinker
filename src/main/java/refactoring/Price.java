package java.refactoring;

public interface Price {

    int getPriceCode();
    double getCharge(int daysRented);
     int getFrequentRenterCharge(int daysRented);
}
