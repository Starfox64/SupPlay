package com.supinfo.supplay.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;

import com.supinfo.supplay.audio.listener.MP_EventListener;
import com.supinfo.supplay.gui.listeners.JB_PlayPauseListener;
import com.supinfo.supplay.gui.listeners.JB_SoundListener;
import com.supinfo.supplay.gui.listeners.JMI_OpenFileListener;
import com.supinfo.supplay.gui.listeners.S_VolumeListener;
import com.supinfo.supplay.gui.listeners.W_CloseListener;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public static final int W_WIDTH = 1000;
	public static final int W_HEIGHT = 550;
	public static final String W_NAME = "SupPlay";
	
	public static final String[] COLUMN_NAMES = {"Name", "Time", "Format"};
	
	private JTable table;
	private JT_Model TModel;
	private JProgressBar jpg;
	private JSlider volume;
	private JButton playButton;
	private JButton soundButton;
	
	private MediaPlayerFactory MPF;
	private EmbeddedMediaPlayer EMP;
	
	private int currentFile;
	
	public Window()
	{
		this.currentFile = -1;
		
		this.setSize(W_WIDTH, W_HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new W_CloseListener(this));

		MPF = new MediaPlayerFactory();
		EMP = MPF.newEmbeddedMediaPlayer();
		EMP.addMediaPlayerEventListener(new MP_EventListener(this));
		EMP.setVolume(50);
		
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
		mi.addActionListener(new JMI_OpenFileListener(this));
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
		Object[][] data = new Object[0][0];
		TModel = new JT_Model(data, COLUMN_NAMES);
		table = new JTable(TModel);
		
		p.add(new JScrollPane(table), BorderLayout.NORTH);
		
		//bottom bar
		JPanel botPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		playButton = new JButton(new ImageIcon(this.getClass().getResource("../img/play-button.png")));
		playButton.addActionListener(new JB_PlayPauseListener(this));
		botPane.add(playButton);
		
		jpg = new JProgressBar(0, 100);
		jpg.setPreferredSize(new Dimension(570, 20));
		botPane.add(jpg);
		
		soundButton = new JButton(new ImageIcon(this.getClass().getResource("../img/sound.png")));
		soundButton.addActionListener(new JB_SoundListener(this));
		botPane.add(soundButton);
		
		volume = new JSlider(0, 100, 50);
		volume.setMajorTickSpacing(10);
		volume.setMinorTickSpacing(1);
		volume.setPaintTicks(false);
		volume.setPaintLabels(false);
		volume.addChangeListener(new S_VolumeListener(this));
		
		
		botPane.add(volume);
		
		botPane.add(new JButton(new ImageIcon(this.getClass().getResource("../img/fullscreen.png"))));
		
		p.add(botPane, BorderLayout.CENTER);
		
		
		return p;
	}
	
	public EmbeddedMediaPlayer getEMP()
	{
		return EMP;
	}
	
	public JTable getTable()
	{
		return table;
	}
	
	public JT_Model getModel()
	{
		return TModel;
	}
	
	public int getCurrentFile()
	{
		return currentFile;
	}
	
	public void incCurrentFile()
	{
		currentFile++;
	}
	
	public JProgressBar getJPG()
	{
		return jpg;
	}

	public JSlider getVolumeSlider()
	{
		return volume;
	}

	public JButton getPlayButton()
	{
		return playButton;
	}
}
