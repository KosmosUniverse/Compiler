public class STElement extends Object {
    public String type;
    public String name;
    public Boolean isConst;
    public Boolean isFunc;
    public Boolean isUsed;
    public Integer argNumber;

    public STElement(String _name, String _type, Boolean _isConst, Boolean _isFunc) {
        type = _type;
        name = _name;
        isConst = _isConst;
        isFunc = _isFunc;
        isUsed = false;
        argNumber = 0;
    }

    public STElement(String _name, String _type, Boolean _isConst, Boolean _isFunc, Integer _argNumber) {
        type = _type;
        name = _name;
        isConst = _isConst;
        isFunc = _isFunc;
        isUsed = false;
        argNumber = _argNumber;
    }
}