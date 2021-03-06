package java.refactoring;

public class Rental
{
    public Rental (Movie movie, int daysRented) {
        this.movie 		= movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented () {
        return daysRented;
    }

    public Movie getMovie () {
        return movie;
    }

    private Movie movie;
    private int daysRented;

    public double getCharge() {
        return movie.getCharge(daysRented);
    }


    public int getFrequentRenterCharge() {
        return movie.getFrequentRenterCharge(daysRented);
    }
}
