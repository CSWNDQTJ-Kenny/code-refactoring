package S01_duplicated_code.M01_extract_method.exception_case.E01_replace_temp_with_query.stage_02;

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
     * 将临时变量 discountFactor 提炼为查询方法
     * 会发现如果不进行 basePrice 的提炼，我们没有办法进行 discountFactor 的提炼
     *
     * @return
     */
    public double getPrice() {
        /*double discountFactor;
        if (basePrice() > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }*/ // todo 提炼 if 判断逻辑
        //double discountFactor = discountFactor(); // todo 创建 discountFactor 的查询方法
        //return basePrice() * discountFactor; // todo 替换用到临时变量 discountFactor 的地方
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
