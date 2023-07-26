package S01_duplicated_code.M01_extract_method.exception_case.E02_replace_method_with_method_object.stage_02;

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
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }

    public int delta() {
        return 1000;
    }

}

/**
 * 抽出新的 方法对象 Gamma
 */
class Gamma {
    private final ReplaceMethodWithMethodObject _replaceMethodWithMethodObject;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    Gamma(ReplaceMethodWithMethodObject replaceMethodWithMethodObject, int inputVal, int quantity, int yearToDate) {
        _replaceMethodWithMethodObject = replaceMethodWithMethodObject;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    /**
     * 现在我们再回头看 if 语句
     * 就容易了
     *
     * @return
     */
    public int compute() {
        importantValue1 = (inputVal * quantity) + _replaceMethodWithMethodObject.delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        /*if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }*/
        importantThing(); // todo extract method
        importantValue3 = importantValue2 * 7;
        return importantValue3 - 2 * importantValue1;
    }

    /**
     * 现在我们很轻松的提炼了 if 语句
     */
    private void importantThing() {
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
    }

}
