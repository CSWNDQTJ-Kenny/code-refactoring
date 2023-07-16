package S01_duplicated_code.M03_form_template_method.stage_04;

import S01_duplicated_code.M03_form_template_method.stage_04.statement.HtmlStatement;
import S01_duplicated_code.M03_form_template_method.stage_04.statement.TextStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * author  : Kenny
 * time    :
 * description : Customer表示顾客，有数据和相应的访问方法
 */

/**
 * 现在我们可以开始正式运用 Form Template Method 抽取模板方法了
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

    public List<Rental> getRentals() {
        return this.rentals;
    }



    /**
     * 提供一个用于生成详单的函数
     */
    public String statement() {
        return new TextStatement().value(this);
    }

    /**
     * 打印 HTML 格式的详单
     *
     * @return
     */
    public String htmlStatement() {
        //客户详单的 HTML 文件
        return new HtmlStatement().value(this);
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
