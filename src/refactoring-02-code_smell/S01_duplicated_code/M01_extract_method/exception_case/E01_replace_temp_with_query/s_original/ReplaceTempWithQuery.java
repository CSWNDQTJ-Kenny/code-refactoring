package S01_duplicated_code.M01_extract_method.exception_case.E01_replace_temp_with_query.s_original;

/**
 * author  :
 * time    :
 * description :
 */
public class ReplaceTempWithQuery {

    private int _quantity;
    private int _itemPrice;

    /**
     * 临时变量的问题是 它们只能在所属函数内使用
     * 所以他们会驱使我们写出更长的方法
     * 而如果把 临时变量 替换为一个方法（查询方法）
     * 那么 同类中的其他方法也可以获得这份信息
     * 这会帮助我们编写更清晰的代码
     *
     * Replace Temp with Query
     * 就会帮助我们替换掉临时变量
     * 若临时变量保存某个表达式的运算结果
     * 那么可以将这个表达式提炼到单独的方法中
     * 接着 所有引用这个临时变量的地方 都替换成这个提炼出来的方法
     *
     * 通常的 Case 是临时变量只被赋值一次
     * 或赋值给临时变量的表达式不受其他条件的影响
     * 这时我们的目的就是要将临时变量 替换为一个查询方法（get方法）
     *
     * 如果我们要替换的临时变量 是用来收集结果的（例如循环累加）
     * 那我们需要将某些程序逻辑（例如循环逻辑）复制到这个查询方法中去
     *
     * @return
     */
    public double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }

}
