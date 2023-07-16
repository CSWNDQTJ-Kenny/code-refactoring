package S01_duplicated_code.M03_form_template_method.stage_final.statement;

import S01_duplicated_code.M03_form_template_method.stage_final.Customer;
import S01_duplicated_code.M03_form_template_method.stage_final.Rental;

/**
 * author  :
 * time    :
 * description :
 */
public class HtmlStatement extends Statement {

    @Override
    public String headerString(Customer customer) {
        return "<H1>Rental Record<EM> for " + customer.getName() + "\n";
    }

    @Override
    public String eachRentalString(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
    }

    @Override
    public String footerString(Customer customer) {
        return "<P> You owe <EM>" + String.valueOf(customer.getTotalCharge()) + "</EM><P>\n"
                + "On this rental You earned <EM>" + String.valueOf(customer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points";
    }

}
