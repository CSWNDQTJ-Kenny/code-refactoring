package S01_duplicated_code.M02_pull_up_method.stage_final;

import java.util.Date;

/**
 * author  :
 * time    :
 * description :
 */
public class PreferredCustomer extends Customer {

    public PreferredCustomer(String name, Date lastBillDate) {
        super(name, lastBillDate);
    }


    @Override
    public double chargeFor(Date start, Date end) {
        var l = end.getTime() - start.getTime();
        return 5.0 * (l / (60.0 * 60.0 * 1000.0));
    }

}
