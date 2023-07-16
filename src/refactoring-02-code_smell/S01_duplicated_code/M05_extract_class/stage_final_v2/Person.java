package S01_duplicated_code.M05_extract_class.stage_final_v2;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * Extract Class
 * 抽取类 TelephoneNumber
 * 并将 抽取出的类 放入 Person类中，形成 inner class
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


    /**
     * 内部类 TelephoneNumber
     */
    public static class TelephoneNumber {

        private String _number;
        private String _areaCode;
        public TelephoneNumber(String areaCode, String number) {
            _areaCode = areaCode;
            _number = number;
        }

        public String getTelephoneNumber() {
            return ("(" + _areaCode + ")" + _number);
        }

        public String get_number() {
            return _number;
        }

        public void set_number(String _number) {
            this._number = _number;
        }

        public String get_areaCode() {
            return _areaCode;
        }

        public void set_areaCode(String _areaCode) {
            this._areaCode = _areaCode;
        }
    }

}
