package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.supinfo.supplay.gui.Window;

public class JB_SoundListener implements ActionListener {

	private Window window;
	private int volume;
	
	public JB_SoundListener(Window window)
	{
		this.window = window;
		volume = 50;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (window.getEMP().getVolume() != 0)
		{
			volume = window.getEMP().getVolume();
			window.getVolumeSlider().setValue(0);
			window.getEMP().setVolume(0);
		}
		else
		{
			window.getVolumeSlider().setValue(volume);
			window.getEMP().setVolume(volume);
		}

	}

}
