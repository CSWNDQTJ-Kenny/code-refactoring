package stage_11;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    /**
     * 运用 Replace Conditional with Polymorphism（以多态取代表达式）
     * 将 新影片的 case 下沉到 NewReleasePrice子类的 getCharge 方法
     */
    /**
     * 获取新影片的租赁费用
     * @param daysRented
     * @return
     */
    @Override
    public double getCharge(int daysRented) {
         //果然还是新书最贵
        return daysRented * 3;
    }

}
