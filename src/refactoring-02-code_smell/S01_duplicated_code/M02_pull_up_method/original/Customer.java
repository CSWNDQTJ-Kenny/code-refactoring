package S01_duplicated_code.M02_pull_up_method.original;

import java.util.Date;
import java.util.List;

/**
 * author  :
 * time    :
 * description :
 */
public class Customer {
    private String name;
    private Date lastBillDate;
    private List<Bill> bills;

    public Customer(String name, Date lastBillDate) {
        this.name = name;
        this.lastBillDate = lastBillDate;
    }

    public String getName(){
        return this.name;
    }

    public Date getLastBillDate() {
        return this.lastBillDate;
    }

    public void addBill(Date date, double amount) {
        bills.add(new Bill(date, amount));
    }
}
