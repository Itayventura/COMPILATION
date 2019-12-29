package AST;

import TYPES.*;
import SYMBOL_TABLE.*;

public class AST_ARR_DEC extends AST_DEC {
	
	String name;
	String type;
	
	public AST_ARR_DEC(String name, String type, int lineNumber){
		this.name = name;
		this.type = type;

		this.setLineNumber(lineNumber);
		System.out.format("====================== arrayDec -> ARRAY ID( %s ) EQ ID( %s ) LBRACK RBRACK", name, type);
	}
	
	public void PrintMe(){
		/****************************************/
		/* AST NODE TYPE = ARRAY DEC (AST NODE) */
		/****************************************/
		System.out.print("AST NODE: ARRAY DEC\n");
		
		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			"ARR\nDEC");
	}

	public TYPE SemantMe() throws SemantException 
	{
		String err;

        TYPE t = SYMBOL_TABLE.getInstance().find(this.type, EntryCategory.Type);
        boolean isArrayDecNameExist = SYMBOL_TABLE.getInstance().existInScope(this.name);

        if (t == null) 
		{ //array element type does not exist
            err = String.format(">> ERROR array_dec: %s %s, type doesn't exist\n", this.name, this.type);
            throw new SemantException(this.getLineNumber(), err);
        }
        if (isArrayDecNameExist) 
		{
            err = String.format(">> ERROR array declaration name %s already exist in the current scope level", this.name);
            throw new SemantException(this.getLineNumber(), err);
        } 
        if(t == TYPE_VOID.getInstance())
		{
        	err = String.format(">> ERROR array declaration name %s, can't use type void\n", this.name);
            throw new SemantException(this.getLineNumber(), err);
        }
        else 
		{
            SYMBOL_TABLE.getInstance().enter(this.name, new TYPE_ARRAY(this.type, 0), EntryCategory.Type);
        }
        return null;
	}

}
	
