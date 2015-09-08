/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.lp.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for LP_Loan_D
 *  @author Adempiere (generated) 
 *  @version Costumizacion por alberto XD - $Id$ */
public class X_LP_Loan_D extends PO implements I_LP_Loan_D, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150901L;

    /** Standard Constructor */
    public X_LP_Loan_D (Properties ctx, int LP_Loan_D_ID, String trxName)
    {
      super (ctx, LP_Loan_D_ID, trxName);
      /** if (LP_Loan_D_ID == 0)
        {
			setLP_Book_ID (0);
			setLP_Loan_Book_ID (0);
			setLP_Loan_D_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LP_Loan_D (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LP_Loan_D[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.lp.model.I_LP_Book getLP_Book() throws RuntimeException
    {
		return (org.lp.model.I_LP_Book)MTable.get(getCtx(), org.lp.model.I_LP_Book.Table_Name)
			.getPO(getLP_Book_ID(), get_TrxName());	}

	/** Set Book.
		@param LP_Book_ID Book	  */
	public void setLP_Book_ID (int LP_Book_ID)
	{
		if (LP_Book_ID < 1) 
			set_Value (COLUMNNAME_LP_Book_ID, null);
		else 
			set_Value (COLUMNNAME_LP_Book_ID, Integer.valueOf(LP_Book_ID));
	}

	/** Get Book.
		@return Book	  */
	public int getLP_Book_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LP_Book_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.lp.model.I_LP_Loan_Book getLP_Loan_Book() throws RuntimeException
    {
		return (org.lp.model.I_LP_Loan_Book)MTable.get(getCtx(), org.lp.model.I_LP_Loan_Book.Table_Name)
			.getPO(getLP_Loan_Book_ID(), get_TrxName());	}

	/** Set Loan Book ID.
		@param LP_Loan_Book_ID Loan Book ID	  */
	public void setLP_Loan_Book_ID (int LP_Loan_Book_ID)
	{
		if (LP_Loan_Book_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LP_Loan_Book_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LP_Loan_Book_ID, Integer.valueOf(LP_Loan_Book_ID));
	}

	/** Get Loan Book ID.
		@return Loan Book ID	  */
	public int getLP_Loan_Book_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LP_Loan_Book_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Loan Details ID.
		@param LP_Loan_D_ID Loan Details ID	  */
	public void setLP_Loan_D_ID (int LP_Loan_D_ID)
	{
		if (LP_Loan_D_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LP_Loan_D_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LP_Loan_D_ID, Integer.valueOf(LP_Loan_D_ID));
	}

	/** Get Loan Details ID.
		@return Loan Details ID	  */
	public int getLP_Loan_D_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LP_Loan_D_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}