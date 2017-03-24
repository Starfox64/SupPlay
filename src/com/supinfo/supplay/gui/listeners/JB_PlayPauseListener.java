package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.supinfo.supplay.gui.Window;

public class JB_PlayPauseListener implements ActionListener {

	private Window window;
	private boolean paused;
	
	public JB_PlayPauseListener(Window window)
	{
		this.window = window;
		paused = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		window.getEMP().pause();
		String file = "";
		if (paused)
		{
			file = "../../img/pause-button.png";
			paused = false;
		}
		else
		{
			file = "../../img/play-button.png";
			paused = true;
		}
		window.getPlayButton().setIcon(
				new ImageIcon(this.getClass().getResource(file))
			);
		
	}

}
