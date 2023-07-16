package S01_duplicated_code.M03_form_template_method.stage_final.price;

import S01_duplicated_code.M03_form_template_method.stage_final.Movie;

public class ChildrenPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }


    /**
     * 获取儿童影片的租赁费用
     *
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
