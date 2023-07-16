package S01_duplicated_code.M03_form_template_method.stage_02;

import S01_duplicated_code.M03_form_template_method.stage_02.statement.HtmlStatement;
import S01_duplicated_code.M03_form_template_method.stage_02.statement.TextStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * author  : Kenny
 * time    :
 * description : Customer表示顾客，有数据和相应的访问方法
 */

/**
 * 运用 Move Method 手法
 * 将原先 Customer 类中，2个负责输出报表的方法，分别搬迁到对应子类中
 * 
 */
public class Customer {
    private String name;
    private List rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }






    /**
     * 为了子类中的方法可以正常编译和运行
     * 需要添加这个 get 方法，并开放 Customer 类中某些函数的权限
     * @return
     */
    public List<Rental> getRentals() {
        return this.rentals;
    }

    /**
     * 提供一个用于生成详单的函数
     */
    public String statement() {
        return new TextStatement().value(this);

        /*String result = "original.Rental Record for " + getName() + "\n";
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;*/
    }

    /**
     * 打印 HTML 格式的详单
     *
     * @return
     */
    public String htmlStatement() {
        //客户详单的 HTML 文件
        return new HtmlStatement().value(this);

        /*String result = "<H1>Rental Record<EM> for " + getName() + "\n";
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "<P> You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental You earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points";
        return result;*/
    }





    /**
     * 查询方法，获取总金额
     *
     * @return
     */
    public double getTotalCharge() {
        double result = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 查询方法，获取总积分
     *
     * @return
     */
    public double getTotalFrequentRenterPoints() {
        int result = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
