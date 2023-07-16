package S01_duplicated_code.M03_form_template_method.stage_final.statement;

import S01_duplicated_code.M03_form_template_method.stage_final.Customer;
import S01_duplicated_code.M03_form_template_method.stage_final.Rental;

/**
 * author  :
 * time    :
 * description :
 */
public abstract class Statement {

    /**
     * 完成本重构后，处理其他种类的报表就容易多了,
     * 我们只需为 Statement 类再建一个子类，
     * 并在其中覆写那 3个抽象方法即可。
     *
     * @param customer
     * @return
     */
    public String value(Customer customer) {
        String result = headerString(customer);
        for (int i = 0; i < customer.getRentals().size(); i++) {
            result += eachRentalString(customer.getRentals().get(i));
        }
        result += footerString(customer);
        return result;
    }

    protected abstract String headerString(Customer customer);

    protected abstract String eachRentalString(Rental rental);

    protected abstract String footerString(Customer customer);
}
