/*
    public Object visit(node, Object data) {

        return (data);
    }
*/

public class Print implements CodeGeneratorVisitor {
    public Object visit(SimpleNode node, Object data) {
        throw new RuntimeException("SimpleNode visit");
    }

    public Object visit(ASTstart node, Object data) {
        System.out.println("Code Start");
        node.jjtGetChild(0).jjtAccept(this, data);
        System.out.println("Code End");
        return (data);
    }

    public Object visit(ASTdecl_list node, Object data) {
        System.out.println("Decl_list");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTdecl node, Object data) {
        System.out.println("Decl");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTvar_decl node, Object data) {
        System.out.println("Var_decl");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTconst_decl node, Object data) {
        System.out.println("Const_decl");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfunction_list node, Object data) {
        System.out.println("Function_list");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfunction node, Object data) {
        System.out.println("Function");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfunction_void node, Object data) {
        System.out.println("Function_void");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Type Start
    public Object visit(ASTtype_integer node, Object data) {
        System.out.println("Type_integer");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTtype_boolean node, Object data) {
        System.out.println("Type_boolean");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // Type End

    public Object visit(ASTparameter_list node, Object data) {
        System.out.println("Parameter_list");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTmain node, Object data) {
        System.out.println("Main");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Start Statement_block
    public Object visit(ASTstmt_id node, Object data) {
        System.out.println("Stmt_id");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTstmt_stmt node, Object data) {
        System.out.println("Stmt_stmt");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTstmt_if node, Object data) {
        System.out.println("Stmt_if");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTstmt_while node, Object data) {
        System.out.println("Stmt_while");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTstmt_skip node, Object data) {
        System.out.println("Stmt_skip");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Statement_block

    // Start Statement_elem
    public Object visit(ASTselem_assign node, Object data) {
        System.out.println("SElem_assign");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTselem_func node, Object data) {
        System.out.println("SElem_func");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Statement_elem

    public Object visit(ASTexpression node, Object data) {
        System.out.println("Expression");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTexpression_one node, Object data) {
        System.out.println("Expression_one");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Start Fragment
    public Object visit(ASTfrag_id node, Object data) {
        System.out.println("Simple_id");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfrag_minus node, Object data) {
        System.out.println("Minus_id");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfrag_number node, Object data) {
        System.out.println("Number");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfrag_true node, Object data) {
        System.out.println("True");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfrag_false node, Object data) {
        System.out.println("False");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfrag_condition node, Object data) {
        System.out.println("Condition");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Fragment

    public Object visit(ASTis_func node, Object data) {
        System.out.println("Is_func");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcalcul node, Object data) {
        System.out.println("Calcul");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Start Binary_op
    public Object visit(ASTbin_plus node, Object data) {
        System.out.println("Bin_plus");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTbin_minus node, Object data) {
        System.out.println("Bin_minus");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Binary_op

    public Object visit(ASTexpression_two node, Object data) {
        System.out.println("Expression_two");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Start Comp_op
    public Object visit(ASTcomp_equal node, Object data) {
        System.out.println("Comp_equal");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcomp_nequal node, Object data) {
        System.out.println("Comp_nequal");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcomp_gequal node, Object data) {
        System.out.println("Comp_gequal");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcomp_lequal node, Object data) {
        System.out.println("Comp_lequal");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcomp_great node, Object data) {
        System.out.println("Comp_great");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcomp_low node, Object data) {
        System.out.println("Comp_low");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Comp_op

    public Object visit(ASTcondition node, Object data) {
        System.out.println("Condition");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Start Condition_one
    public Object visit(ASTcond_tilde node, Object data) {
        System.out.println("Cond_tilde");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTcond_expr node, Object data) {
        System.out.println("Cond_expr");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Condition_one

    public Object visit(ASTcondition_two node, Object data) {
        System.out.println("Condition_two");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    // Start Op
    public Object visit(ASTop_or node, Object data) {
        System.out.println("Op_or");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTop_and node, Object data) {
        System.out.println("Op_and");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
    // End Op

    public Object visit(ASTarg_list node, Object data) {
        System.out.println("Arg_list");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

        public Object visit(ASTarg_elem node, Object data) {
        System.out.println("Arg_elem");
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }
}