package S01_duplicated_code.M01_extract_method.exception_case.E01_replace_temp_with_query.stage_01;

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
     * 将临时变量 basePrice 提炼为查询方法
     *
     * @return
     */
    public double getPrice() {
        //int basePrice = _quantity * _itemPrice; // todo 提炼计算表达式
        //int basePrice = basePrice(); // todo 创建查询方法，这里为了名称方便理解，没有使用 getBasePrice
        double discountFactor;
        //if (basePrice > 1000) { // todo 需要将临时变量替换为查询方法
        if (basePrice() > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }
        //return basePrice * discountFactor; // todo 需要将临时变量替换为查询方法
        return basePrice() * discountFactor;
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }

}
