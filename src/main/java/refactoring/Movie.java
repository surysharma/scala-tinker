package java.refactoring;

public class Movie {
    public static final int CHILDRENS	= 2;
    public static final int REGULAR 	= 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private Price price;

    public Movie (String title, int priceCode) {
        this.title 	= title;
        setPriceCode(priceCode);
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


    public int getFrequentRenterCharge(int daysRented) {
       return price.getFrequentRenterCharge(daysRented);
    }

    public int getPriceCode () {
        return priceCode;
    }

    private void setPriceCode (int code) {
        priceCode = code;
        switch (priceCode) {
            case Movie.REGULAR:
               price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
               price = new NewReleasesPrice();
                break;
            case Movie.CHILDRENS:
               price = new ChildrenPrice();
                break;
        }
        priceCode = price.getPriceCode();
    }

    public String getTitle () {
        return title;
    }

}