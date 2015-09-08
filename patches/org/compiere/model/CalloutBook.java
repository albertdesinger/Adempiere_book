package org.compiere.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.util.DB;
import org.compiere.util.Env;



//open class main
public class CalloutBook extends CalloutEngine {	
	public String getNextNumber (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		
	
			
			//String
			String sql = "SELECT MAX(Number_Loan)  FROM LP_Loan_Book";
			PreparedStatement pstm = null;
			ResultSet rs = null;

			
			try{
			
				pstm = DB.prepareStatement(sql,null);
				rs = pstm.executeQuery();
				Integer MaxNumber = 0;
				
				//open if
				if(rs.next()){
					MaxNumber = rs.getInt(1);
					Env.setContext(ctx, WindowNo, "Number_Loan", MaxNumber+1);
					mTab.setValue("Number_Loan", MaxNumber+1);
					
				}//close if
				
				
			}catch(SQLException ex){
				
				log.log(Level.SEVERE, sql, ex);
				return ex.getLocalizedMessage();
				
			}//close catch
			finally{
				DB.close(rs, pstm);
				rs = null; pstm = null;
			}
		
			
			
		return "";
	}
	
}//close class
