package Lotter;

//import java.util.Arrays;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Layout_Design extends JFrame {
	protected boolean cond = false;
	
	protected ArrayList Wards = new ArrayList();
	protected ArrayList Names = new ArrayList();

	protected Font font = new Font("Dialog", Font.PLAIN, 20);
	
	protected JTextField txt = new JTextField();

	protected JLabel lblTheme = new JLabel("主題");
	protected JLabel lblName = new JLabel("待抽名單");
	protected JLabel lblwards = new JLabel("獎項");
	protected JLabel lblresult = new JLabel("結果");
	protected JLabel lbloutput = new JLabel("result");

	protected List listName = new List();
	protected List listwards = new List();
	protected List listoutput = new List();

//	protected JComboBox boxTheme = new JComboBox(strTheme);
	protected JComboBox boxTheme = new JComboBox();

	protected JPanel pNorth = new JPanel();
	protected JPanel pCenter = new JPanel();

	protected Container c = this.getContentPane();

	Layout_Design(){
		super("抽獎系統");
		this.setBounds(100, 50, 300, 280);

		BorderLayout layout = new BorderLayout();
		c.setLayout(layout);
		c.add(pNorth, BorderLayout.NORTH);
		c.add(pCenter, BorderLayout.CENTER);
		

		set_pNorth();
		set_pCenter();
	}

	private void set_pNorth() {
		pNorth.setLayout(new GridLayout(2, 3));

		lblTheme.setFont(font);

		boxTheme.setFont(font);

		pNorth.add(lblTheme);
		pNorth.add(new JLabel());
		pNorth.add(boxTheme);
		pNorth.add(lblName);
		pNorth.add(lblwards);
		pNorth.add(lblresult);

	}

	private void set_pCenter() {
		pCenter.setLayout(new BorderLayout());
		Panel p2 = new Panel();
		
		pCenter.add(p2,BorderLayout.CENTER);
		
		p2.setLayout(new GridLayout(1,3));
		p2.add(listName);
		p2.add(listwards);
		p2.add(listoutput);
		

		lblName.setFont(font);

		lblwards.setFont(font);

		lblresult.setFont(font);
		
		listName.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		listwards.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		listoutput.setFont(new Font("Dialog", Font.PLAIN, 16));
		

	}

}
