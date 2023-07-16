package S01_duplicated_code.M03_form_template_method.original.price;

import S01_duplicated_code.M03_form_template_method.original.Movie;

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
     * 获取看新片儿的积分
     *
     * @param daysRented
     * @return
     */
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

}
