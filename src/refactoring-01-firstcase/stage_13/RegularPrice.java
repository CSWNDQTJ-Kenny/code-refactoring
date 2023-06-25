package stage_13;

public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }


    /**
     * 获取普通影片的租赁费用
     *
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