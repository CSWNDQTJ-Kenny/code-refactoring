package S01_duplicated_code.M03_form_template_method.stage_02;

import S01_duplicated_code.M03_form_template_method.stage_02.price.ChildrenPrice;
import S01_duplicated_code.M03_form_template_method.stage_02.price.NewReleasePrice;
import S01_duplicated_code.M03_form_template_method.stage_02.price.Price;
import S01_duplicated_code.M03_form_template_method.stage_02.price.RegularPrice;

/**
 * author  : Kenny
 * time    :
 * description : Movie记录类型、价格和标题等，单纯数据类。
 */
public class Movie {

    //三种片类型
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    private String title;
    private Price price;

    /**
     * Movie类的构造函数
     *
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }


    public int getPriceCode() {
        return price.getPriceCode();
    }


    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code !");
        }
    }

    public String getTitle() {
        return title;
    }


    /**
     * 获取租赁当前影片所需要的费用
     *
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


    /**
     * 获得租赁当前影片而获得的积分
     *
     * @param daysRented
     * @return
     */
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }


}
