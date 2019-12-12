public class TestStable extends Object {
    public static void main(String args[]) {
        STable table = new STable();

        table.printStack();
        
        table.addElem(new STElement("Name 1", "Type 1"));
        table.addBreak();

        table.printStack();

        table.addElem(new STElement("Name 2", "Type 2", true));
        table.printStack();

        System.out.println(table.findElem("Name 1"));

        System.out.println("remove until break");

        table.removeUntilBreak();
        table.printStack();
    }
}