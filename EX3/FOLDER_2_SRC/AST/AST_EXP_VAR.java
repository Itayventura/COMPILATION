package AST;

import TYPES.*;

public class AST_EXP_VAR extends AST_EXP
{
	public AST_VAR var;


	public AST_EXP_VAR(AST_VAR var) {
		System.out.print("====================== exp -> var\n");
		this.var = var;
	}
	
	public void PrintMe() {
		/************************************/
		/* AST NODE TYPE = EXP VAR AST NODE */
		/************************************/
		System.out.print("AST NODE: EXP VAR\n");

		/*****************************/
		/* RECURSIVELY PRINT var ... */
		/*****************************/
		if (var != null) var.PrintMe();
		
		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			"EXP\nVAR");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,var.SerialNumber);
			
	}
	
	public TYPE SemantMe()
	{
		return null;
	}
}
