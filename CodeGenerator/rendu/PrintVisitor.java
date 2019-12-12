public class PrintVisitor implements CodeGeneratorVisitor {
    public Object visit(SimpleNode node, Object data) {
        throw new RuntimeException("visit SimpleNode");
    }

    public Object visit(ASTstart node, Object data) {
        System.out.println("Code Start {");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        System.out.println("}\nCode End");
        return (data);
    }

    public Object visit(ASTdecl_list node, Object data) {
        System.out.println("Decl_list {");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        System.out.println("}");
        return (data);
    }

    public Object visit(ASTdecl node, Object data) {
        System.out.println("Declaration :");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTvar_decl node, Object data) {
        System.out.println("Kind: Var\nName: " + node.value);
        node.jjtGetChild(0).jjtAccept(this, data);
        System.out.println("");
        return (data);
    }


    public Object visit(ASTconst_decl node, Object data) {
        System.out.println("Kind: Const\nName: " + node.value);
        node.jjtGetChild(0).jjtAccept(this, data);
        node.jjtGetChild(1).jjtAccept(this, data);
        System.out.println("");
        return (data);
    }

    public Object visit(ASTfunction_list node, Object data) {
        System.out.println("Function_list {");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        System.out.println("}");
        return (data);
    }

    public Object visit(ASTfunction node, Object data) {
        System.out.println("Function:\nName: " + node.value);
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfunction_void node, Object data) {
        System.out.println("Function:\nName: " + node.value);
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTtype node, Object data) {
        System.out.println("Type: " + node.value);
        return (data);
    }


    public Object visit(ASTparameter_list node, Object data) {
        System.out.println("Param: " + node.value);
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTmain node, Object data) {
        System.out.println("Main {");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        System.out.println("}");
        return (data);
    }

    public Object visit(ASTstatement_block node, Object data) {
        System.out.println("Statement_block: " + node.value + "{");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        System.out.println("}");
        return (data);
    }

    public Object visit(ASTassign node, Object data) {
        System.out.print("=");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfuncarg node, Object data) {
        System.out.print("(");
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            node.jjtGetChild(i).jjtAccept(this, data);
        }
        System.out.println(")");
        return (data);
    }


    public Object visit(ASTexpression node, Object data) {
        System.out.print("expression: {");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        System.out.println("}");
        return (data);
    }

    public Object visit(ASTexpression_one node, Object data) {
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfragment node, Object data) {
        System.out.print("fragment: " + node.value);
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTis_func node, Object data) {
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            System.out.print(" ");
            node.jjtGetChild(i).jjtAccept(this, data);
        }
        return (data);
    }

    public Object visit(ASTcalcul node, Object data) {
        System.out.print("calcul: ");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }


    public Object visit(ASTbinary_op node, Object data) {
        System.out.print(node.value + " ");
        return (data);
    }

    public Object visit(ASTexpression_two node, Object data) {
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcomp_op node, Object data) {
        System.out.println("comp_op: " + node.value);
        return (data);
    }

    public Object visit(ASTcondition node, Object data) {
        System.out.println("condition: ");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTtildecond node, Object data) {
        System.out.print("~(");
        node.jjtGetChild(0).jjtAccept(this, data);
        System.out.println(")");
        return (data);
    }


    public Object visit(ASTcondexpr node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcondition_two node, Object data) {
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTop node, Object data) {
        System.out.println("op: " + node.value);
        return (data);
    }

    public Object visit(ASTarg_list node, Object data) {
        System.out.print("arg: " + node.value + ",");
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
            node.jjtGetChild(i).jjtAccept(this, data);
        return (data);
    }
}