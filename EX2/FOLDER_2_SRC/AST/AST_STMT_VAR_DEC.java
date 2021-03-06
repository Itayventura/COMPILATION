package AST;

public class AST_STMT_VAR_DEC  extends AST_STMT {
	
	public AST_VAR_DEC varDec;

	
	public AST_STMT_VAR_DEC(AST_VAR_DEC varDec) {
		this.varDec = varDec;

		System.out.print("====================== stmt -> varDec\n");
	}
	
	
	public void PrintMe() {
		/*******************************************/
		/* AST NODE TYPE = STMT VAR DEC (AST NODE) */
		/*******************************************/
		System.out.print("AST NODE: STMT VAR DEC\n");

		/********************************/
		/* RECURSIVELY PRINT varDec ... */
		/********************************/
		if (varDec != null) varDec.PrintMe();
		
		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			"STMT\nVAR\nDEC");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, varDec.SerialNumber);
	}


}
