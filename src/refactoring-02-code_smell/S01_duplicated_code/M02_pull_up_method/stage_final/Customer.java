package S01_duplicated_code.M02_pull_up_method.stage_final;

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
     * 创建订单
     * @param currentDate
     */
    public void createBill(Date currentDate) {
        double changeAmount = chargeFor(this.getLastBillDate(), currentDate);
        addBill(currentDate, changeAmount);
    }

    /**
     * 计算订单费用
     * @param start
     * @param end
     * @return
     */
    protected abstract double chargeFor(Date start, Date end);

}
