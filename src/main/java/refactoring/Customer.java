package java.refactoring;

import java.util.Vector;
import java.util.Enumeration;

public class Customer {
    public Customer (String name) {
        this.name = name;
    }

    public void addRental (Rental rental) {
        rentals.addElement (rental);
    }

    public String getName () {
        return name;
    }

    public String statement () {

        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName () + "\n";

        while (rentals.hasMoreElements ()) {
            Rental rental = (Rental)rentals.nextElement();
            result += "\t" + rental.getMovie().getTitle () + "\t"
                    + String.valueOf (rental.getCharge()) + "\n";
        }
        result += "You owed " + String.valueOf (getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf (getFrequentRenterPoints()) + " frequent renter points\n";

        return result;
    }

    private double getTotalCharge() {
        double 	totalAmount = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental)rentals.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements ();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental)rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterCharge();
        }
        return frequentRenterPoints;
    }



    private String name;
    private Vector rentals = new Vector ();
}