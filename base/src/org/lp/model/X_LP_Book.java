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
import org.compiere.util.KeyNamePair;

/** Generated Model for LP_Book
 *  @author Adempiere (generated) 
 *  @version Costumizacion por alberto XD - $Id$ */
public class X_LP_Book extends PO implements I_LP_Book, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150901L;

    /** Standard Constructor */
    public X_LP_Book (Properties ctx, int LP_Book_ID, String trxName)
    {
      super (ctx, LP_Book_ID, trxName);
      /** if (LP_Book_ID == 0)
        {
			setLP_Author_ID (0);
			setLP_Book_ID (0);
			setLP_Category_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_LP_Book (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LP_Book[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.lp.model.I_LP_Author getLP_Author() throws RuntimeException
    {
		return (org.lp.model.I_LP_Author)MTable.get(getCtx(), org.lp.model.I_LP_Author.Table_Name)
			.getPO(getLP_Author_ID(), get_TrxName());	}

	/** Set Author.
		@param LP_Author_ID Author	  */
	public void setLP_Author_ID (int LP_Author_ID)
	{
		if (LP_Author_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LP_Author_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LP_Author_ID, Integer.valueOf(LP_Author_ID));
	}

	/** Get Author.
		@return Author	  */
	public int getLP_Author_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LP_Author_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Book.
		@param LP_Book_ID Book	  */
	public void setLP_Book_ID (int LP_Book_ID)
	{
		if (LP_Book_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LP_Book_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LP_Book_ID, Integer.valueOf(LP_Book_ID));
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

	public org.lp.model.I_LP_Category getLP_Category() throws RuntimeException
    {
		return (org.lp.model.I_LP_Category)MTable.get(getCtx(), org.lp.model.I_LP_Category.Table_Name)
			.getPO(getLP_Category_ID(), get_TrxName());	}

	/** Set Category.
		@param LP_Category_ID Category	  */
	public void setLP_Category_ID (int LP_Category_ID)
	{
		if (LP_Category_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LP_Category_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LP_Category_ID, Integer.valueOf(LP_Category_ID));
	}

	/** Get Category.
		@return Category	  */
	public int getLP_Category_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LP_Category_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Status.
		@param Status 
		Status of the currently running check
	  */
	public void setStatus (boolean Status)
	{
		set_Value (COLUMNNAME_Status, Boolean.valueOf(Status));
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public boolean isStatus () 
	{
		Object oo = get_Value(COLUMNNAME_Status);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}