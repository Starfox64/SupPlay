package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.supinfo.supplay.gui.Window;

public class JB_PlayPauseListener implements ActionListener {

	private Window window;
	
	public JB_PlayPauseListener(Window window)
	{
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		window.getEMP().pause();
	}

}
