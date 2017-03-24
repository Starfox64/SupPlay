package com.supinfo.supplay.gui.listeners;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.supinfo.supplay.gui.Window;

public class S_VolumeListener implements ChangeListener {

	private Window window;
	
	public S_VolumeListener(Window window)
	{
		this.window = window;
	}
	
	@Override
	public void stateChanged(ChangeEvent arg) {
		JSlider source = (JSlider)arg.getSource();
	    if (!source.getValueIsAdjusting()) {
	        window.getEMP().setVolume(source.getValue());
	    }
	}

}
