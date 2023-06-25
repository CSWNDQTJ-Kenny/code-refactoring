package stage_12;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }


    /**
     * 获取新影片的租赁费用
     *
     * @param daysRented
     * @return
     */
    @Override
    public double getCharge(int daysRented) {
        //果然还是新书最贵
        return daysRented * 3;
    }

    /**
     * Price类的getFrequentRenterPoints中
     * 关于看新片的 积分计算逻辑 下沉到了子类NewReleasePrice的覆写方法中
     */
    /**
     * 获取看新片儿的积分
     * @param daysRented
     * @return
     */
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

}
