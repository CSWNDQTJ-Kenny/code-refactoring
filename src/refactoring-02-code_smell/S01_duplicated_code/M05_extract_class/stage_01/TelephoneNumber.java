package S01_duplicated_code.M05_extract_class.stage_01;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * 该类封装了与 “电话号码” 相关的数据
 */
public class TelephoneNumber {

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
