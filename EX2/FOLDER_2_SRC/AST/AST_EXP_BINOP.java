package AST;

public class AST_EXP_BINOP extends AST_EXP {
	public AST_BINOP op;
	public AST_EXP left;
	public AST_EXP right;
	

	public AST_EXP_BINOP(AST_EXP left,AST_EXP right, AST_BINOP op) {

		System.out.print("====================== exp -> exp BinOp exp\n");

		/*******************************/
		/* COPY INPUT DATA NENBERS ... */
		/*******************************/
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	/*************************************************/
	/* The printing message for a binop exp AST node */
	/*************************************************/
	public void PrintMe() {
		/*********************************/
		/* AST NODE TYPE = AST EXP BINOP */
		/*********************************/
		System.out.format("AST NODE: EXP BINOP\n", op);

		/*********************************************/
		/* RECURSIVELY PRINT left, op, and right ... */
		/*********************************************/
		if (left != null) left.PrintMe();
		if(op != null) op.PrintMe();
		if (right != null) right.PrintMe();

		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			String.format("EXP\nBINOP", op));

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, left.SerialNumber);
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, op.SerialNumber);
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, right.SerialNumber);
	}

}
