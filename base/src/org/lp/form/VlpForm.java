package org.lp.form;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.logging.Level;

import javax.swing.plaf.ColorUIResource;

import jxl.biff.drawing.ComboBox;

import org.adempiere.plaf.AdempiereTaskPaneUI;
import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.grid.ed.VComboBox;
import org.compiere.grid.ed.VDate;
import org.compiere.grid.ed.VLookup;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.plaf.CompiereColor;
import org.compiere.swing.CButton;
import org.compiere.swing.CLabel;
import org.compiere.swing.CPanel;
import org.compiere.swing.CTextField;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.jdesktop.swingx.JXTaskPane;
import org.posterita.exceptions.WarehouseAlreadyExistsException;

public class VlpForm implements FormPanel, VetoableChangeListener, ActionListener {

	
	
	public void init (int WindowNo, FormFrame frame)
	{
		log.info("");
		m_WindowNo = WindowNo;
		m_frame = frame;
		try
		{
			dynInit();
			jbInit();
			frame.getContentPane().add(commandPanel, BorderLayout.SOUTH);
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, "", e);
		}
	}	//	init
	
	int m_WindowNo;
	private CLogger log = CLogger.getCLogger(VlpForm.class);
	private FormFrame m_frame;
	private CPanel panel = new CPanel();
	private CPanel mainPanel = new CPanel();
	private BorderLayout mainLayout = new BorderLayout();
	private CPanel parameterPanel = new CPanel();
	
	
	//add  JTXFIELD
	private JXTaskPane warehouseStockPanel = new JXTaskPane();
	
	private CPanel C_Blast_credit = new CPanel();
	private GridBagLayout G_Blast = new GridBagLayout();

	
	//file1
	private CLabel labelTotalAcobrar = new CLabel("Total a cobrar");
	private CTextField labelResulTotal = new CTextField("1000,00");
	private CLabel labelSaldo = new CLabel("Saldo");
	
	
	//file2
	private VLookup c_Pago = null;
	private CTextField t_Pago = new CTextField("100,00");
	private CButton buttonComboPago = new CButton("+");
	
	//file3
	private VLookup ComboxTargeta = null;
	private CTextField fieldTargeta = new CTextField("200,00");
	
	
	//file4
	private CTextField NumberSite = new CTextField("00123");
	private CTextField Site = new CTextField("Venezuela");
	private CTextField NumberSite2 = new CTextField("393");
	
	
	
	//file5
	private CLabel title_cheque = new CLabel("Cheque");
	private CTextField number1Cheque = new CTextField("012345");
	private CTextField number2Cheque = new CTextField("150,00");
	
	//file6
	private CTextField tipyBank = new CTextField("MERCANTIL");
	private VDate fecha_banco = new VDate();
	
	//file7
	private VComboBox C_blast = new VComboBox();
	private	CLabel T_blast = new CLabel("100,00");
	
	//file8
	private VComboBox C_Type_Blast = new VComboBox();
	private CTextField T_number_blast = new CTextField("11/16");
	//file9
	private CLabel L_name_client = new CLabel("Alberto Vargas");
	private CTextField C_CI_CLient = new CTextField("20467294");
	
	
	//button
	private CButton Cancel = new CButton("X");
	private CButton Save = new CButton("S");
	
	
	//campo table para diseñar el layout
	private GridBagLayout parameterLayout = new GridBagLayout();
	private CPanel commandPanel = new CPanel();
	
	
	//JBinit 
	private void jbInit() throws Exception
	{
		
		CompiereColor.setBackground(panel);
		//
		mainPanel.setLayout(mainLayout);
		parameterPanel.setLayout(parameterLayout);
		C_Blast_credit.setLayout(G_Blast);
		//
		
		
		//ADD
		parameterPanel.add(labelTotalAcobrar,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		parameterPanel.add(labelResulTotal,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		parameterPanel.add(labelSaldo,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		//file2
		parameterPanel.add(c_Pago,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(t_Pago,  new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(buttonComboPago,  new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		
		//file3	
		parameterPanel.add(ComboxTargeta,  new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(fieldTargeta,  new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		
		
		//file4	
		parameterPanel.add(NumberSite,  new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(Site,  new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(NumberSite2,  new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		
		//file5
		parameterPanel.add(title_cheque,  new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(number1Cheque,  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(number2Cheque,  new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		
		//file6
		parameterPanel.add(tipyBank,  new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(fecha_banco,  new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
	
		//file buttons
	
		parameterPanel.add(Cancel,  new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		parameterPanel.add(Save,  new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		
		
		//items
		C_blast.addItem("Tipo de targetas");
		C_blast.addItem("Targetas");
		C_blast.addItem("Targetas2");
		
		
		C_Blast_credit.add(C_blast,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		C_Blast_credit.add(T_blast,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		
		C_Type_Blast.addItem("Visa");
		C_Type_Blast.addItem("Mastercard");
		C_Blast_credit.add(C_Type_Blast,  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		C_Blast_credit.add(T_number_blast,  new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		C_Blast_credit.add(L_name_client,  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		C_Blast_credit.add(C_CI_CLient,  new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		
		
		mainPanel.add(parameterPanel, BorderLayout.NORTH);
		
		//despegabke
		warehouseStockPanel.setTitle("Text Example Stock Panel Alberto");
	    warehouseStockPanel.setUI(new AdempiereTaskPaneUI());
	    warehouseStockPanel.getContentPane().setBackground(new ColorUIResource(251,248,241));
	    warehouseStockPanel.getContentPane().setForeground(new ColorUIResource(251,0,0));
		
	    warehouseStockPanel.setCollapsed(true);
        warehouseStockPanel.add(C_Blast_credit);
        mainPanel.add(warehouseStockPanel);
   
	    
	}
	
	
	
	//dynInit Crear  elementos dinamicos
	private void dynInit()
	{	
		
	//  C_PaySelection_ID
			int AD_Column_ID = 5046;        //  C_PaySelectionCheck.C_PaySelection_ID
			MLookup lookupPS = MLookupFactory.get (Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.List);
			c_Pago = new VLookup("TenderType", true, false, true, lookupPS);
			c_Pago.addVetoableChangeListener(this);
			
			//c_PaymenType
			int CreditCardType = 3869;
			MLookup lookupType = MLookupFactory.get(Env.getCtx(),m_WindowNo, 0, CreditCardType, DisplayType.List);
			ComboxTargeta = new VLookup("CreditCardType",true,false,true,lookupType);
			ComboxTargeta.addVetoableChangeListener(this);
			
	}
	
	
	
	
	
	

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}



	@Override
	public void vetoableChange(PropertyChangeEvent evt)
			throws PropertyVetoException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
