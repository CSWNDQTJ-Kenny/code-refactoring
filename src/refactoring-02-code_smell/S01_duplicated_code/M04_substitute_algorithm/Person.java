package S01_duplicated_code.M04_substitute_algorithm;

/**
 * author  :
 * time    :
 * description :
 */
public class Person {

    public String foundPerson(String[] people) {
        for (String person : people) {
            if (person.equals("Don")) {
                return "Don";
            }
            if (person.equals("John")) {
                return "John";
            }
            if (person.equals("Kent")) {
                return "Kent";
            }
        }
        return "";
    }


}
