package S01_duplicated_code.M03_form_template_method.stage_02.statement;

import S01_duplicated_code.M03_form_template_method.stage_02.Customer;
import S01_duplicated_code.M03_form_template_method.stage_02.Rental;

/**
 * author  :
 * time    :
 * description :
 */
public class TextStatement extends Statement {

    /**
     * 为了方便后续操作，我们将 TextStatement 和 HtmlStatement 类中的 “打印报表” 方法的名称统一
     * 因为，此时两个类之间 “打印报表” 的差异不在方法名称，而在于方法所属的类
     * 于是，搬迁来子类后，我们给方法改名为 value
     *
     * @param customer
     * @return
     */
    public String value(Customer customer) {
        String result = "original.Rental Record for " + customer.getName() + "\n";
        for (int i = 0; i < customer.getRentals().size(); i++) {
            Rental each = customer.getRentals().get(i);
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

}
