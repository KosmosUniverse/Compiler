public class STElement extends Object {
    String type;
    String name;
    boolean isConst;

    public STElement(String _name, String _type) {
        type = _type;
        name = _name;
        isConst = false;
    }

    public STElement(String _name, String _type, Boolean _isConst) {
        type = _type;
        name = _name;
        isConst = _isConst;
    }

    public String getName() {
        return (name);
    }

    public String getType() {
        return (type);
    }
}