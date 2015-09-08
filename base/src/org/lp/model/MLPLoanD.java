package org.lp.model;

import java.util.Properties;

import org.compiere.util.Env;

public class MLPLoanD extends X_LP_Loan_D {

	public MLPLoanD(Properties ctx, int LP_Loan_D_ID, String trxName) {
		super(ctx, LP_Loan_D_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	//variables
	X_LP_Book lp_book;

	//afterSave Book
	protected boolean afterSave (boolean newRecord, boolean success)
	{	
		System.out.println("AHORA SI ENTRO POR ACA");
		//When we insert a new record after saving shares
		if(newRecord){
			super.afterSave(newRecord, success);

			lp_book = new X_LP_Book(Env.getCtx(), this.getLP_Book_ID(), get_TrxName());
			lp_book.setStatus(false);
			lp_book.saveEx();
		}
		//end if
		return true;
	}
	
	
	private static final long serialVersionUID = 1L;

}
