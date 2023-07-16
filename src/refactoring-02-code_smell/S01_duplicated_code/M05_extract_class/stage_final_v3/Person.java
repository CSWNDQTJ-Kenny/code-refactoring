package S01_duplicated_code.M05_extract_class.stage_final_v3;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * Extract Class 抽取类 TelephoneNumber
 * 同一个 Java 文件中，只能有一个类可以声明为 public，也只有这个 public 类可以有 main 方法
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



/**
 * Extract Class
 * 抽取类 TelephoneNumber
 * 并将 抽取出的类 放入 Person类的 文件 中，方便归类、查看
 */
class TelephoneNumber {

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
