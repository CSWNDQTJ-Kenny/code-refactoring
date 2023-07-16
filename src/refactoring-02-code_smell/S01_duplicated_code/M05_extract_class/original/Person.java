package S01_duplicated_code.M05_extract_class.original;

/**
 * author  :
 * time    :
 * description :
 */

/**
 * 一个类应该是一个清楚的抽象，处理一些明确的责任。
 * 但是,在实际工作中，类会不断成长扩展。我们会在类中加入一些功能和数据。
 * 给某个类添加一项新责任时，我们会觉得不值得为这项责任分离出一个单独的类。
 * 于是，随着责任不断增加，这个类会变得过分复杂，很快的，我们的类就会变成一团乱麻。
 * <p>
 * 这种类往往含有大量方法和数据，因而不易理解。
 * 此时我们需要考虑哪些部分可以分离出去，并将它们分离到一个单独的类中。
 * 如果某些数据和某些方法总是一起出现，某些数据经常同时变化甚至彼此相依，这就表示应该将它们分离出去。
 * 我们需要问自己，如果搬移了某些字段和方法，会发生什么事？其他字段和方法是否因此变得没有意义？
 * <p>
 * 另一个通常在开发后期出现的信号是类的子类化方式。
 * 如果我们发现 子类 只影响类的部分特性，
 * 或如果发现某些特性需要以一种方式来子类化，某些特性则需要以另一种方式子类化，
 * 这就意味我们需要分解原来的类。
 */
public class Person {

    private String _name;
    private String _officeAreaCode;
    private String _officeNumber;

    public Person(String name, String officeAreaCode, String officeNumber) {
        _name = name;
        _officeAreaCode = officeAreaCode;
        _officeNumber = officeNumber;
    }

    public String getTelephoneNumber() {
        return ("(" + _officeAreaCode + ")" + _officeNumber);
    }

    public String get_name() {
        return _name;
    }

    public String get_officeAreaCode() {
        return _officeAreaCode;
    }

    public String get_officeNumber() {
        return _officeNumber;
    }

    public void setOfficeAreaCode(String _officeAreaCode) {
        this._officeAreaCode = _officeAreaCode;
    }

    public void setOfficeNumber(String _officeNumber) {
        this._officeNumber = _officeNumber;
    }

}
