package stage_11;

public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    /**
     * 运用 Replace Conditional with Polymorphism（以多态取代表达式）
     * 将 新影片的 case 下沉到 RegularPrice子类的 getCharge 方法
     */
    /**
     * 获取普通影片的租赁费用
     * @param daysRented
     * @return
     */
    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        //优惠力度
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}