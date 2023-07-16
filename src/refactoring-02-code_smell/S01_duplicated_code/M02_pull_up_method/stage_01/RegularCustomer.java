package S01_duplicated_code.M02_pull_up_method.stage_01;

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

    /**
     * 将 createBill 方法上提到 Customer 类
     *
     * @param start
     * @param end
     * @return
     */
    /*public void createBill(Date currentDate) {
        double changeAmount = chargeFor(this.getLastBillDate(), currentDate);
        addBill(currentDate, changeAmount);
    }*/

    public double chargeFor(Date start, Date end) {
        var l = end.getTime() - start.getTime();
        return 10.0 * (l / (60.0 * 60.0 * 1000.0));
    }

}
