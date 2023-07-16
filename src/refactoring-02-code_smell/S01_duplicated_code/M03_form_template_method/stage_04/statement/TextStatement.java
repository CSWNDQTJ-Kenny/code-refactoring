package S01_duplicated_code.M03_form_template_method.stage_04.statement;

import S01_duplicated_code.M03_form_template_method.stage_04.Customer;
import S01_duplicated_code.M03_form_template_method.stage_04.Rental;

/**
 * author  :
 * time    :
 * description :
 */
public class TextStatement extends Statement {

    /**
     * 所有这些修改都完成后，两个子类的 value 方法看上去己经非常相似了，
     * 因此可以使用 Pull up Method 手法，将子类的 value方法 提升到超类中。
     * 提升完毕后，需要在超类中把子类函数声明为抽象函数。
     *
     * @param customer
     * @return
     */
//    public String value(Customer customer) {
        /*String result = headerString(customer);
        for (int i = 0; i < customer.getRentals().size(); i++) {
            result += eachRentalString(customer.getRentals().get(i));
        }
        result += footerString(customer);
        return result;*/
//    }

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
