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
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public static final int W_WIDTH = 1200;
	public static final int W_HEIGHT = 800;
	public static final String W_NAME = "SupPlay";
	
	public static final String[] COLUMN_NAMES = {"Name", "Time", "Format"};
	
	private static JTable table;
	
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
		JPanel p = new JPanel(new BorderLayout());
		
		//grid
		List<List<Object>> data = new ArrayList<>();
		table = new JTable(new JT_Model(data, COLUMN_NAMES));
		p.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//bottom bar
		JPanel southPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton play = new JButton("Play / Pause");
		play.addActionListener(new JB_PlayPauseListener());
		southPane.add(play);
		
		JProgressBar bar = new JProgressBar(0, 100);
		southPane.add(bar);
		
		p.add(southPane, BorderLayout.SOUTH);
		
		
		return p;
	}
	
	
	public static JTable getTable()
	{
		return table;
	}
}
