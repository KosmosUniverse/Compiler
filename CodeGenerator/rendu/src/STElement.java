public class STElement extends Object {
    public String type;
    public String name;
    public Boolean isConst;
    public Boolean isFunc;

    public STElement(String _name, String _type, Boolean _isConst, Boolean _isFunc) {
        type = _type;
        name = _name;
        isConst = _isConst;
        isFunc = _isFunc;
    }
}