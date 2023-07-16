package S01_duplicated_code.M03_form_template_method.stage_final.statement;

import S01_duplicated_code.M03_form_template_method.stage_final.Customer;
import S01_duplicated_code.M03_form_template_method.stage_final.Rental;

/**
 * author  :
 * time    :
 * description :
 */
public class TextStatement extends Statement {

    @Override
    public String headerString(Customer customer) {
        return "original.Rental Record for " + customer.getName() + "\n";
    }

    @Override
    public String eachRentalString(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
    }

    @Override
    public String footerString(Customer customer) {
        return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n"
                + "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

}
