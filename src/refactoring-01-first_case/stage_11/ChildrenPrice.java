package stage_11;

public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    /**
     * 运用 Replace Conditional with Polymorphism（以多态取代表达式）
     * 将 新影片的 case 下沉到 ChildrenPrice子类的 getCharge 方法
     */
    /**
     * 获取儿童影片的租赁费用
     * @param daysRented
     * @return
     */
    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

}
