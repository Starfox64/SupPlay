package com.supinfo.supplay.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.supinfo.supplay.gui.listeners.JB_PlayPauseListener;
import com.supinfo.supplay.gui.listeners.JMI_OpenFileListener;
import com.supinfo.supplay.gui.listeners.W_CloseListener;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public static final int W_WIDTH = 1200;
	public static final int W_HEIGHT = 600;
	public static final String W_NAME = "SupPlay";
	
	public static final String[] COLUMN_NAMES = {"Name", "Time", "Format"};
	
	private JTable table;
	
	public Window()
	{
		this.setSize(W_WIDTH, W_HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new W_CloseListener());
		
		
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
		JPanel p = new JPanel(new BorderLayout());
		
		//grid
		List<List<Object>> data = new ArrayList<>();
		table = new JTable(new JT_Model(data, COLUMN_NAMES));
		p.add(new JScrollPane(table), BorderLayout.NORTH);

		//bottom bar
		JPanel botPane = new JPanel(new FlowLayout());
		JButton b = new JButton("Play");
		b.addActionListener(new JB_PlayPauseListener());
		botPane.add(b);
		p.add(botPane, BorderLayout.CENTER);
		
		
		return p;
	}
	
	
	public JTable getTable()
	{
		return table;
	}
}
