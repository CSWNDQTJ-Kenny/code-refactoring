package S01_duplicated_code.M01_extract_method.exception_case.E01_replace_temp_with_query.stage_final;

/**
 * author  :
 * time    :
 * description :
 */
public class ReplaceTempWithQuery {

    private int _quantity;
    private int _itemPrice;

    /**
     * Replace Temp with Query
     * 我们的目的就是要将临时变量 替换为一个 查询方法
     *
     * 我们已经将两个临时变量 basePrice & discountFactor 均替换为了 其值的查询方法
     *
     * @return
     */
    public double getPrice() {
        return basePrice() * discountFactor();
    }

    private double discountFactor() {
        double result;
        if (basePrice() > 1000) {
            result = 0.95;
        } else {
            result = 0.98;
        }
        return result;
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }

}
