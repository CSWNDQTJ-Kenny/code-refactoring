package S01_duplicated_code.M03_form_template_method.stage_03.statement;

import S01_duplicated_code.M03_form_template_method.stage_03.Customer;
import S01_duplicated_code.M03_form_template_method.stage_03.Rental;

/**
 * author  :
 * time    :
 * description :
 */
public class TextStatement extends Statement {

    /**
     * 重点：运用 Extract Method 方法将两个方法的不同部分提炼出来，
     * 从而将相似的代码和变动的代码分开。
     * 每次提炼后，就建立一个签名相同但本体不同的函数。
     *
     * @param customer
     * @return
     */
    public String value(Customer customer) {
//        String result = "original.Rental Record for " + customer.getName() + "\n";
        String result = headerString(customer);
        for (int i = 0; i < customer.getRentals().size(); i++) {
//            Rental each = customer.getRentals().get(i);
//            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            result += eachRentalString(customer.getRentals().get(i));
        }
//        result += "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
//        result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
        result += footerString(customer);
        return result;
    }

    private String headerString(Customer customer) {
        return "original.Rental Record for " + customer.getName() + "\n";
    }

    private String eachRentalString(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
    }

    private String footerString(Customer customer) {
        return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n"
                + "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

}
