package S01_duplicated_code.M04_substitute_algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * author  :
 * time    :
 * description :
 */
public class Customer {

    public String foundCustomer(String[] customer) {
        var candidates = Arrays.asList("Don", "John", "Kent");
        for (String s : customer) {
            if (candidates.contains(s)) {
                return s;
            }
        }
        return "";
    }

}
