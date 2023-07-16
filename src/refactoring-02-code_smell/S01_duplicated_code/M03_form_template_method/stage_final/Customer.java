package S01_duplicated_code.M03_form_template_method.stage_final;

import S01_duplicated_code.M03_form_template_method.stage_final.statement.HtmlStatement;
import S01_duplicated_code.M03_form_template_method.stage_final.statement.TextStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * author  : Kenny
 * time    :
 * description : Customer表示顾客，有数据和相应的访问方法
 */

/**
 * 完成本重构后，处理其他种类的报表就容易多了,
 * 我们只需为 Statement 类再建一个子类，
 * 并在其中覆写那 3个抽象方法即可。
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
     * @return
     */
    public String statement() {
        return new TextStatement().value(this);
    }

    /**
     * 打印 HTML 格式的详单
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
