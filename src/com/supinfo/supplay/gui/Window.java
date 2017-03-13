package com.supinfo.supplay.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public static final int W_WIDTH = 1200;
	public static final int W_HEIGHT = 800;
	public static final String W_NAME = "SupPlay";
	
	public static final String[] COLUMN_NAMES = {"Name", "Time", "Format"};
	
	private JTable table;
	
	public Window()
	{
		this.setSize(W_WIDTH, W_HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle(W_NAME);
		
		this.setJMenuBar(this.generateMenuBar());
		
		this.setContentPane(this.generatePanel());
		
		this.setVisible(true);
	}
	
	private JMenuBar generateMenuBar()
	{
		JMenuBar mb = new JMenuBar();
		
		JMenu m = new JMenu("File");
		JMenuItem mi = new JMenuItem("Open file");
		mi.addActionListener(new JMI_OpenFileListener());
		m.add(mi);
		
		mb.add(m);
		
		//following JMenu s do not have any JMenuItem, therefore aren't customized as precedently
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("View"));
		mb.add(new JMenu("Help"));
		
		return mb;
	}
	
	private JPanel generatePanel()
	{
		/*JPanel p = new JPanel();
		JScrollPane sp = new JScrollPane();
		
		Object[][] data = {};
		this.table = new JTable(50, 3);
		//sp.add(table);
		
		JPanel pCenter = new JPanel();

		p.add(table, BorderLayout.CENTER);
		//pCenter.add(sp);
		*/
		
		JPanel p = new JPanel(new BorderLayout());
		
		Object[][] data = {};
		this.table = new JTable(new JT_Model(data, COLUMN_NAMES));
		JPanel pCenter = new JPanel(new FlowLayout());

		pCenter.add(new JScrollPane(table));
		p.add(pCenter, BorderLayout.CENTER);
		
		return p;
	}
	
	
	public JTable getTable()
	{
		return this.table;
	}
}
