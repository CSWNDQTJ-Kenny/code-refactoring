package S01_duplicated_code.M05_extract_class.stage_01;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * 这个类看着有点乱
 * 我们现在想把跟 “电话号码” 这个概念抽取出来，放入 TelephoneNumber 类中
 */
public class Person {

    private String _name;
//    private String _officeAreaCode;
//    private String _officeNumber;
    private TelephoneNumber _officeTelephone;


    public Person(String name, String officeAreaCode, String officeNumber) {
        _name = name;
//        _officeAreaCode = officeAreaCode;
//        _officeNumber = officeNumber;
        _officeTelephone = new TelephoneNumber(officeAreaCode, officeNumber);
    }


    public String getTelephoneNumber() {
//        return ("(" + _officeAreaCode + ")" + _officeNumber);
        return _officeTelephone.getTelephoneNumber();
    }

    public String get_name() {
        return _name;
    }

    public TelephoneNumber get_officeTelephone() {
        return _officeTelephone;
    }

    /*public String get_officeAreaCode() {
        return _officeAreaCode;
    }*/

    /*public String get_officeNumber() {
        return _officeNumber;
    }*/

   /* public void setOfficeAreaCode(String _officeAreaCode) {
        this._officeAreaCode = _officeAreaCode;
    }*/

    /*public void setOfficeNumber(String _officeNumber) {
        this._officeNumber = _officeNumber;
    }*/

}
