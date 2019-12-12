import java.util.ArrayList;

public class STable extends Object {
    ArrayList<STElement> stack = new ArrayList<STElement>();;

    public STable() {
    }

    public void addElem(STElement elem){
        stack.add(0, elem);
    }

    public void addBreak(){
        STElement elem = new STElement("Break", "Break");
        stack.add(0, elem);
    }

    public Boolean findElem(String name) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).getName().equals(name))
                return (true);
        }
        return (false);
    }

    public void removeUntilBreak() {
        int count = 0;
        for (; count < stack.size(); count++) {
            if (stack.get(count).getName().equals("Break"))
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
            System.out.println("Element " + i + "\n\tName: " + stack.get(i).getName() + "\n\tType: " + stack.get(i).getType());
        }
    }
}