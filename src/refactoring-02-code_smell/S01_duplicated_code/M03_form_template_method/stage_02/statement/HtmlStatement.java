package S01_duplicated_code.M03_form_template_method.stage_02.statement;

import S01_duplicated_code.M03_form_template_method.stage_02.Customer;

/**
 * author  :
 * time    :
 * description :
 */
public class HtmlStatement extends Statement {

    /**
     * 为了方便后续操作，我们将 TextStatement 和 HtmlStatement 类中的 “打印报表” 方法的名称统一
     * 因为，此时两个类之间 “打印报表” 的差异不在方法名称，而在于方法所属的类
     * 于是，搬迁来子类后，我们给方法改名为 value
     *
     * @param customer
     * @return
     */
    public String value(Customer customer){
        String result = "<H1>Rental Record<EM> for " + customer.getName() + "\n";
        for (int i = 0; i < customer.getRentals().size(); i++) {
            result += "\t" + customer.getRentals().get(i).getMovie().getTitle() + "\t" + String.valueOf(customer.getRentals().get(i).getCharge()) + "\n";
        }
        result += "<P> You owe <EM>" + String.valueOf(customer.getTotalCharge()) + "</EM><P>\n";
        result += "On this rental You earned <EM>" + String.valueOf(customer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points";
        return result;
    }

}
