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
package org.lp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LP_Loan_D
 *  @author Adempiere (generated) 
 *  @version Costumizacion por alberto XD
 */
public interface I_LP_Loan_D 
{

    /** TableName=LP_Loan_D */
    public static final String Table_Name = "LP_Loan_D";

    /** AD_Table_ID=1000058 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LP_Book_ID */
    public static final String COLUMNNAME_LP_Book_ID = "LP_Book_ID";

	/** Set Book	  */
	public void setLP_Book_ID (int LP_Book_ID);

	/** Get Book	  */
	public int getLP_Book_ID();

	public org.lp.model.I_LP_Book getLP_Book() throws RuntimeException;

    /** Column name LP_Loan_Book_ID */
    public static final String COLUMNNAME_LP_Loan_Book_ID = "LP_Loan_Book_ID";

	/** Set Loan Book ID	  */
	public void setLP_Loan_Book_ID (int LP_Loan_Book_ID);

	/** Get Loan Book ID	  */
	public int getLP_Loan_Book_ID();

	public org.lp.model.I_LP_Loan_Book getLP_Loan_Book() throws RuntimeException;

    /** Column name LP_Loan_D_ID */
    public static final String COLUMNNAME_LP_Loan_D_ID = "LP_Loan_D_ID";

	/** Set Loan Details ID	  */
	public void setLP_Loan_D_ID (int LP_Loan_D_ID);

	/** Get Loan Details ID	  */
	public int getLP_Loan_D_ID();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
