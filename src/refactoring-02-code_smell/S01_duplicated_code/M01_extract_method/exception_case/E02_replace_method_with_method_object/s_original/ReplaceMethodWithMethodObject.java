package S01_duplicated_code.M01_extract_method.exception_case.E02_replace_method_with_method_object.s_original;

/**
 * author  :
 * time    :
 * description :
 */
public class ReplaceMethodWithMethodObject {

    /**
     * Replace Method with Method Object
     * 小型方法固然优美，但是 局部变量的存在会大大增加分解方法的难度
     * 如果一个方法中 局部变量 泛滥成灾，那么很可能我们无法分解该方法，
     * 尽管我们可以使用 Replace Temp with Query 来帮助我们尽可能减轻负担，
     * 但有时我们还是无法继续分解剩下来的大方法
     * <p>
     * 于是我们祭出终极大招。。
     * Replace Method with Method Object
     * 该手法会将所有局部变量都变成 新的方法对象 的成员变量
     * 然后再运用 Extract Method 手法创建新方法
     * 从而将大型方法拆解变短
     * <p>
     * 这对这个 Case 我们希望抽出 if 语句
     *
     * @param inputVal
     * @param quantity
     * @param yearToDate
     * @return
     */
    public int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        return importantValue3 - 2 * importantValue1;
    }

    private int delta() {
        return 1000;
    }

}
