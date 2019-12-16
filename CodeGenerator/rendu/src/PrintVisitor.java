import java.util.List;
import java.util.ArrayList;

public class PrintVisitor implements CodeGeneratorVisitor {
    public static int tmpCount = 0;
    public static int labelCount = 0;

    public static String tmpGenerator() {
        tmpCount += 1;
        return ("t" + tmpCount);
    }

    public static String labelGenerator() {
        labelCount += 1;
        return ("Lbl" + labelCount);
    }

    public Object visit(SimpleNode node, Object data) {
        throw new RuntimeException("visit SimpleNode");
    }

    public Object visit(ASTstart node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt decl = new SStmt();
        SStmt func = new SStmt();
        SStmt _main = new SStmt();
        node.jjtGetChild(0).jjtAccept(this, decl);
        node.jjtGetChild(1).jjtAccept(this, func);
        node.jjtGetChild(2).jjtAccept(this, _main);
        if (decl.code != "")
            dat.code = decl.code;
        if (func.code != "")
            dat.code += func.code + "\n";
        dat.code += _main.code;
        return (data);
    }

    public Object visit(ASTdecl_list node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt first = new SStmt();
        SStmt second = new SStmt();
        node.jjtGetChild(0).jjtAccept(this, first);
        node.jjtGetChild(1).jjtAccept(this, second);
        if (first.code != "")
            dat.code += first.code + "\n";
        if (second.code != "")
            dat.code += second.code;
        return (data);
    }

    public Object visit(ASTdecl_empty node, Object data) {
        return (data);
    }

    public Object visit(ASTvar_decl node, Object data) {
         return (data);
    }


    public Object visit(ASTconst_decl node, Object data) {
        SStmt dat = (SStmt)data;
        SExpr expr = new SExpr();
        node.jjtGetChild(1).jjtAccept(this, expr);
        if (expr.code != "")
            dat.code += expr.code + "\n";
        dat.code += (String)node.value + " = " + expr.addr;
        return (data);
    }

    public Object visit(ASTfunction_list node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt left = new SStmt();
        SStmt right = new SStmt();
        node.jjtGetChild(0).jjtAccept(this, left);
        node.jjtGetChild(1).jjtAccept(this, right);
        if (right.code == "") {
            dat.code = left.code;
        } else {
            right.next = dat.next;
            dat.code = left.code + "\n" + right.code;
        }
        return (data);
    }

    public Object visit(ASTfunction_empty node, Object data) {
        return (data);
   }

    public Object visit(ASTfunction node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt decl = new SStmt();
        SStmt stmt = new SStmt();
        SExpr ret = new SExpr();
        node.jjtGetChild(2).jjtAccept(this, decl);
        node.jjtGetChild(3).jjtAccept(this, stmt);
        node.jjtGetChild(4).jjtAccept(this, ret);
        dat.code = (String)node.value + ": ";
        if (decl.code != "")
            dat.code += decl.code + "\n";
        if (stmt.code != "")
            dat.code += stmt.code + "\n";
        if (ret.code != "")
            dat.code += ret.code + "\n";
        dat.code += "return " + ret.addr + "\n";
        return (data);
    }

    public Object visit(ASTfunction_void node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt decl = new SStmt();
        SStmt stmt = new SStmt();
        node.jjtGetChild(1).jjtAccept(this, decl);
        node.jjtGetChild(2).jjtAccept(this, stmt);
        dat.code = (String)node.value + ": ";
        if (decl.code != "")
            dat.code += decl.code + "\n";
        if (stmt.code != "")
            dat.code += stmt.code + "\n";
        return (data);
    }

    public Object visit(ASTtype node, Object data) {
        return (data);
    }


    public Object visit(ASTparameter_list node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        node.jjtGetChild(1).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTparameter_empty node, Object data) {
        return (data);
    }

    public Object visit(ASTparameter_elem node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        node.jjtGetChild(1).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTparameter_elem_empty node, Object data) {
        return (data);
    }

    public Object visit(ASTmain node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt decl = new SStmt();
        SStmt stmt = new SStmt();
        node.jjtGetChild(0).jjtAccept(this, decl);
        node.jjtGetChild(1).jjtAccept(this, stmt);
        dat.code = "Main: ";
        if (decl.code != "")
            dat.code += decl.code + "\n";
        if (stmt.code != "")
            dat.code += stmt.code + "\n";
        return (data);
    }

    public Object visit(ASTstatement_block node, Object data) {
        SStmt dat = (SStmt)data;
        SStmt first = new SStmt();
        SStmt second = new SStmt();
        first.next = labelGenerator();
        second.next = dat.next;
        node.jjtGetChild(0).jjtAccept(this, first);
        node.jjtGetChild(1).jjtAccept(this, second);
        if (first.code != "") {
            dat.code += first.code + "\n";
        }
        if (second.code != "") {
            dat.code +=  second.code;
        }
        return (data);
    }

    public Object visit(ASTstatement_empty node, Object data) {
        return (data);
    }

    public Object visit(ASTstmt_id node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTstmt_stmt node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTstmt_if node, Object data) {
        SStmt dat = (SStmt)data;
        SBool cond = new SBool();
    	SStmt if_block = new SStmt();
        SStmt else_block = new SStmt();
        cond._true = labelGenerator();
        cond._false = labelGenerator();
        node.jjtGetChild(0).jjtAccept(this, cond);
	    node.jjtGetChild(1).jjtAccept(this, if_block);
        node.jjtGetChild(2).jjtAccept(this, else_block);
        if_block.next = else_block.next = dat.next;
        dat.code = cond.code + cond._true + ": " + if_block.code + "goto " + dat.next + "\n" + cond._false + ": " + else_block.code + "\n" + dat.next + ":";
        return (data);
    }

    public Object visit(ASTstmt_while node, Object data) {
        SStmt dat = (SStmt)data;
        SBool cond = new SBool();
        SStmt elem = new SStmt();
        cond._true = labelGenerator();
        cond._false = dat.next;
        node.jjtGetChild(0).jjtAccept(this, cond);
	    node.jjtGetChild(1).jjtAccept(this, elem);
        String begin = labelGenerator();
        elem.next = begin;
	    dat.code = begin + ": " + cond.code + "\n" + cond._true + ": " + elem.code + "goto " + begin + "\n" + dat.next + ":";
        return (data);
    }

    public Object visit(ASTassign node, Object data) {
        SStmt dat = (SStmt)data;
        SExpr expr = new SExpr();
        node.jjtGetChild(0).jjtAccept(this, expr);
        dat.code = expr.code + "\n";
        dat.code += (String)node.value + " = " + expr.addr;
        return (data);
    }

    public Object visit(ASTfuncarg node, Object data) {
        SStmt dat = (SStmt)data;
        SExpr func = new SExpr();
        List<String> params;
        func.addr = tmpGenerator();

        params = (ArrayList)node.jjtGetChild(0).jjtAccept(this, data);
        for (String param : params) {
            func.code += "param " + param + "\n";
        }
        func.code += func.addr + " = call " + (String)node.value + " " + params.size();
        dat.code = func.code + "\n" + (String)node.value + " = " + func.addr;
        return (data);
    }

    public Object visit(ASTexpression node, Object data) {
        if (node.jjtGetNumChildren() == 3) {
            SBool dat = (SBool)data;
            SExpr left = new SExpr();
            SExpr mid = new SExpr();
            SExpr right = new SExpr();
            node.jjtGetChild(0).jjtAccept(this, left);
            node.jjtGetChild(1).jjtAccept(this, mid);
            node.jjtGetChild(2).jjtAccept(this, right);
            if (left.code != "")
                dat.code += left.code + "\n";
            if (right.code != "")
                dat.code += right.code + "\n";
            dat.code += "if " + left.addr + " " + mid.addr + " " + right.addr + " goto " + dat._true + "\ngoto " + dat._false + "\n";
        } else {
            node.jjtGetChild(0).jjtAccept(this, data);
        }
        return (data);
    }

    public Object visit(ASTexpression_one node, Object data) {
        if (node.jjtGetNumChildren() == 3) {
            SExpr dat = (SExpr)data;
            SExpr left = new SExpr();
            SExpr mid = new SExpr();
            SExpr right = new SExpr();
            node.jjtGetChild(0).jjtAccept(this, left);
            node.jjtGetChild(1).jjtAccept(this, mid);
            node.jjtGetChild(2).jjtAccept(this, right);
            dat.addr = tmpGenerator();
            if (left.code != "")
                dat.code = left.code + "\n";
            if (right.code != "")
                dat.code = right.code + "\n";
            dat.code += dat.addr + " = " + left.addr + " " + mid.addr + " " + right.addr;
        } else {
            node.jjtGetChild(0).jjtAccept(this, data);
        }
        return (data);
    }

    public Object visit(ASTfrag_id node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTfrag_minus node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = tmpGenerator();
        dat.code = dat.addr + " = " + (String)node.value;
        return (data);
    }

    public Object visit(ASTfrag_num node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = (String)node.value;
        return (data);
    }

    public Object visit(ASTfrag_bool node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = (String)node.value;
        return (data);
    }

    public Object visit(ASTfrag_cond node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTis_func node, Object data) {
        SExpr dat = (SExpr)data;
        List<String> params;

        dat.addr = tmpGenerator();
        params = (ArrayList)node.jjtGetChild(0).jjtAccept(this, data);
        for (String param : params) {
            dat.code += "param " + param + "\n";
        }
        dat.code += dat.addr + " = call " + (String)node.value + " " + params.size();
        return (dat);
    }

    public Object visit(ASTis_id node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = (String)node.value;
        return (data);
    }

    public Object visit(ASTbinary_op node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = (String)node.value;
        return (data);
    }


    public Object visit(ASTcomp_op node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = (String)node.value;
        return (data);
    }

    public Object visit(ASTcondition node, Object data) {
        if (node.jjtGetNumChildren() == 3) {
            SBool dat = (SBool)data;
            SBool left = new SBool();
            SExpr mid = new SExpr();
            SBool right = new SBool();
            node.jjtGetChild(0).jjtAccept(this, left);
            node.jjtGetChild(1).jjtAccept(this, mid);
            node.jjtGetChild(2).jjtAccept(this, right);
            if (mid.addr == "&&") {
                left._true = labelGenerator();
                left._false = dat._false;
                right._true = dat._true;
                right._false = dat._false;
                dat.code = left.code + "\n" + left._true + ": " + right.code;
            } else {
                left._true = dat._true;
                left._false = labelGenerator();
                right._true = dat._true;
                right._false = dat._false;
                dat.code = left.code + "\n" + left._false + ": " + right.code;
            }
        } else {
            node.jjtGetChild(0).jjtAccept(this, data);
        }
        return (data);
    }

    public Object visit(ASTtildecond node, Object data) {
        SBool dat = (SBool)data;
        SBool cond = new SBool();
        node.jjtGetChild(0).jjtAccept(this, cond);
        cond._true = dat._false;
        cond._false = dat._true;
        dat.code = cond.code;
        return (data);
    }


    public Object visit(ASTcondexpr node, Object data) {
        node.jjtGetChild(0).jjtAccept(this, data);
        return (data);
    }

    public Object visit(ASTop node, Object data) {
        SExpr dat = (SExpr)data;
        dat.addr = (String)node.value;
        return (data);
    }

    public Object visit(ASTarg_list node, Object data) {
        List<String> params;
        params = (ArrayList)node.jjtGetChild(0).jjtAccept(this, data);
        params.add((String)node.value);
        return (params);
    }

    public Object visit(ASTarg_empty node, Object data) {
        List<String> params = new ArrayList();
        return (params);
    }

    public Object visit(ASTarg_elem node, Object data) {
        List<String> params;
        params = (ArrayList)node.jjtGetChild(0).jjtAccept(this, data);
        params.add((String)node.value);
        return (params);
    }

    public Object visit(ASTarg_elem_empty node, Object data) {
        List<String> params = new ArrayList();
        return (params);
    }
}