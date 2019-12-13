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

    public void addFuncParam(String name, Integer count) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).name.equals(name) && stack.get(i).isFunc) {
                stack.get(i).argNumber = count;
                return ;
            }
        }
    }

    public STElement findElem(String name) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).name.equals(name))
                return (stack.get(i));
        }
        return (null);
    }

    public void checkElemDef(String name, ArrayList<String> errors) {
        STElement elem = findElem(name);
        if (elem != null) {
            errors.add("Multiple definition of " + name);
        }
    }

    public void checkElemUse(String name, Boolean isFunc, Integer argNumber, ArrayList<String> errors) {
        STElement elem = findElem(name);
        if (elem != null) {
            if (elem.isFunc != isFunc) {
                if (isFunc)
                    errors.add(name + " is a variable not a function.");
                else
                    errors.add(name + " is a function.");
            } else {
                elem.isUsed = true;
                if (isFunc) {
                    if (elem.argNumber != argNumber)
                        errors.add(name + " does not have the good number of arguments. It have " + argNumber + " arguments instead of " + elem.argNumber);                        
                }
            }
        } else {
            errors.add(name + " does not exists.");
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