import java.util.ArrayList;

public class STable extends Object {
    ArrayList<STElement> stack = new ArrayList<STElement>();;

    public STable() {
    }

    public void addElem(STElement elem){
        stack.add(0, elem);
    }

    public void addElem(String _name, String _type, Boolean _isConst, Boolean _isFunc){
        STElement elem = new STElement(_name, _type, _isConst, _isFunc);
        stack.add(0, elem);
    }

    public void addBreak(){
        STElement elem = new STElement("Break", "Break", false, false);
        stack.add(0, elem);
    }

    public STElement findElem(String name) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).name.equals(name))
                return (stack.get(i));
        }
        return (null);
    }

    public void checkElem(String name, Boolean isFunc, ArrayList<String> errors) {
        STElement elem = findElem(name);
        if (elem != null) {
            if (elem.isFunc != isFunc)
                errors.add("Function: " + name + " does not exists.");
        } else {
            errors.add("Function: " + name + " does not exists.");
        }
    }

    public void removeUntilBreak() {
        int count = 0;
        for (; count < stack.size(); count++) {
            if (stack.get(count).name.equals("Break"))
                break;
        }
        for (; count >= 0; count--)
            stack.remove(0);
    }

    public void printStack() {
        if (stack.isEmpty()) {
            System.out.println("Empty Stack");
            return ;
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("Element " + i + "\n\tName: " + stack.get(i).name + "\n\tType: " + stack.get(i).type);
        }
    }
}