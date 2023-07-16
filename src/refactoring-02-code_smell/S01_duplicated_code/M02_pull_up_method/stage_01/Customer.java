package S01_duplicated_code.M02_pull_up_method.stage_01;

import java.util.Date;
import java.util.List;

/**
 * author  :
 * time    :
 * description :
 */
public abstract class Customer {
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

    /**
     * 从 PreferredCustomer 和 RegularCustomer 类 拉取上来的共同方法
     * 同时将方法内需要使用的 chargFor方法也向上抽取成 abstract 方法，
     * 利用多态保证子类各自的差异
     *
     * @param currentDate
     */
    public void createBill(Date currentDate) {
        double changeAmount = chargeFor(this.getLastBillDate(), currentDate);
        addBill(currentDate, changeAmount);
    }

    protected abstract double chargeFor(Date start, Date end);

}
