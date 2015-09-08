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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for LP_Loan_Book
 *  @author Adempiere (generated) 
 *  @version Costumizacion por alberto XD - $Id$ */
public class X_LP_Loan_Book extends PO implements I_LP_Loan_Book, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150901L;

    /** Standard Constructor */
    public X_LP_Loan_Book (Properties ctx, int LP_Loan_Book_ID, String trxName)
    {
      super (ctx, LP_Loan_Book_ID, trxName);
      /** if (LP_Loan_Book_ID == 0)
        {
			setLP_Loan_Book_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LP_Loan_Book (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LP_Loan_Book[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set Usuario.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get Usuario.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set End Date.
		@param EndDate 
		Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return Last effective date (inclusive)
	  */
	public Timestamp getEndDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
	}

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

	/** Set Number Loan.
		@param Number_Loan Number Loan	  */
	public void setNumber_Loan (int Number_Loan)
	{
		set_Value (COLUMNNAME_Number_Loan, Integer.valueOf(Number_Loan));
	}

	/** Get Number Loan.
		@return Number Loan	  */
	public int getNumber_Loan () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Number_Loan);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Start Date.
		@param StartDate 
		First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate)
	{
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}
}