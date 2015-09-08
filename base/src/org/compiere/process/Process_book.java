package org.compiere.process;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.compiere.model.MUser;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.lp.model.X_LP_Book;
import org.lp.model.X_LP_Loan_Book;

public class Process_book extends SvrProcess  {

	

	int user_id;
	int lp_loan_book_id;
	String message;
	
	
	//INSTANCE
	X_LP_Loan_Book loan;
	X_LP_Book lp_book;
	MUser myuser;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
		
		//Aqui Buscaremos los parametros que tiene el informe o proceso
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("AD_User_ID"))
				user_id = para[i].getParameterAsInt();
				
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		
		
	}
	
	
	
	@Override 
 	protected String doIt() throws Exception {
		//Performing the default execution
		System.out.println("Llamando el proceso.....!");
		
		
		//Performing the SQL query to find whether the user has an active loan
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT lp_loan_book_id FROM lp_loan_book WHERE  ad_user_id='"+user_id+"' AND isactive='Y'";
		
		try{
			
			pstmt = DB.prepareStatement(sql, null);
			//pstmt.setInt(1,user_id);
			rs = pstmt.executeQuery(); 
			if(rs.next()){
				lp_loan_book_id = rs.getInt(1);
				loan = new X_LP_Loan_Book(Env.getCtx(), lp_loan_book_id, get_TrxName());
				loan.setIsActive(false);
				loan.saveEx();
				
				//update status book
				update_status_book(lp_loan_book_id);
				myuser = new MUser(Env.getCtx(), user_id, get_TrxName());
				message = "Se ha realizado el proceso de devolucion del usuario "+myuser.getName();
				
			}else{
				message = "Este usuario no posee prestamos activos";
			}
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
			
		}catch(SQLException Ex){
			log.log(Level.SEVERE, sql, Ex);
			return Ex.getLocalizedMessage();
		}
		
		
		return message;	
	}
	
	
	
	
	//function update status book
	private void update_status_book(int loan_book_id){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT lp_book_id FROM lp_loan_d WHERE lp_loan_book_id='"+loan_book_id+"'";
		try{
			pstmt = DB.prepareStatement(sql, null);
			rs = pstmt.executeQuery();
			
			//open while 
			while(rs.next()){				
				//update book
				lp_book = new X_LP_Book(Env.getCtx(), rs.getInt(1), get_TrxName());
				lp_book.setStatus(true);
				lp_book.saveEx();
			}//close while 
			
		}catch(SQLException ex){
			log.log(Level.SEVERE, sql, ex);
		}//close catch
		
	}//close function
	
	
	
	

}
