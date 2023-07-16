package S01_duplicated_code.M02_pull_up_method.original;

import java.util.Date;

/**
 * author  :
 * time    :
 * description :
 */
public class RegularCustomer extends Customer {

    public RegularCustomer(String name, Date lastBillDate) {
        super(name, lastBillDate);
    }

    public void createBill(Date currentDate) {
        double changeAmount = chargeFor(this.getLastBillDate(), currentDate);
        addBill(currentDate, changeAmount);
    }

    private double chargeFor(Date start, Date end) {
        var l = end.getTime() - start.getTime();
        return 10.0 * (l / (60.0 * 60.0 * 1000.0)); // 普通用户每小时10元
    }

}
