package S01_duplicated_code.M05_extract_class.stage_final;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * Extract Class
 * 抽取类
 */
public class Person {

    private String _name;
    private TelephoneNumber _officeTelephone;


    public Person(String name, String officeAreaCode, String officeNumber) {
        _name = name;
        _officeTelephone = new TelephoneNumber(officeAreaCode, officeNumber);
    }

    public String getTelephoneNumber() {
        return _officeTelephone.getTelephoneNumber();
    }

    public String get_name() {
        return _name;
    }

    public TelephoneNumber get_officeTelephone() {
        return _officeTelephone;
    }


}
