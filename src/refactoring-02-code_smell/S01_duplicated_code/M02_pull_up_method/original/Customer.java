package S01_duplicated_code.M02_pull_up_method.original;

import java.util.Date;
import java.util.List;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * 避免行为重复是很重要的。
 * 尽管重复的两个函数也可以各自工作得很好，
 * 但重复自身只会成为错误的滋生地，此外别无价值。
 * 无论何时，只要系统之内出现重复，我们就会面临“修改其中一个却未能修改另一个"的风险。
 * 通常，找出重复也有一定困难。
 *
 * 如果在子类中的方法体内 发现相同的代码段时
 * 我们就可以使用 Pull Up Method 手段，消除这些重复代码
 * 观察这些可能重复的方法之间的差异也往往大有收益。
 *
 * 麻烦的一点是：被提升的方法 可能会引用 只出现于子类 而不出现于超类的特性。
 * 如果被引用的子类特性是个方法，我们可以将该方法也一同提升到超类，或者在超类中建立一个抽象函数。
 * 在此过程中，我们可能需要修改某个函数的签名，或建立一个委托函数。
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
