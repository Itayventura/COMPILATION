package AST;

import TYPES.*;
import SYMBOL_TABLE.*;

public class AST_STMT_IF extends AST_STMT
{
	public AST_EXP cond;
	public AST_STMT_LIST body;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AST_STMT_IF(AST_EXP cond,AST_STMT_LIST body)
	{
		this.cond = cond;
		this.body = body;

		System.out.print("====================== stmt -> IF LPAREN exp RPAREN LBRACE stmtList RBRACE\n");
	}


	public void PrintMe() {
		/**************************************/
		/* AST NODE TYPE = STMT IF (AST NODE) */
		/**************************************/
		System.out.print("AST NODE: STMT IF\n");

		/***************************************/
		/* RECURSIVELY PRINT cond and body ... */
		/***************************************/
		if (cond != null) cond.PrintMe();
		if (body != null) body.PrintMe();
		
		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			"STMT\nIF");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, cond.SerialNumber);
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, body.SerialNumber);
	}
	
	public TYPE SemantMe()
	{
		/****************************/
		/* [0] Semant the Condition */
		/****************************/
		/*
		if (cond.SemantMe() != TYPE_INT.getInstance())
		{
			System.out.format(">> ERROR [%d:%d] condition inside IF is not integral\n",2,2);
		}*/
		
		/*************************/
		/* [1] Begin Class Scope */
		/*************************/
		/*SYMBOL_TABLE.getInstance().beginScope();*/

		/***************************/
		/* [2] Semant Data Members */
		/***************************/
		/*body.SemantMe();*/

		/*****************/
		/* [3] End Scope */
		/*****************/
		/*SYMBOL_TABLE.getInstance().endScope();*/

		/*********************************************************/
		/* [4] Return value is irrelevant for class declarations */
		/*********************************************************/
		return null;		
	}
	
}