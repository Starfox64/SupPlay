package com.supinfo.supplay.audio.listener;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.supinfo.supplay.gui.Window;

import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

public class MP_EventListener extends MediaPlayerEventAdapter {

	private Window window;
	
	public MP_EventListener(Window window)
	{
		this.window = window;
	}
	
	@Override
	public void finished(MediaPlayer mediaPlayer) {
		//play next file if there's one
	}
	
	@Override
	public void error(MediaPlayer mediaPlayer) {
		JOptionPane.showMessageDialog(null,
				"Failed to read the file",
				"An Error Has Occured",
				JOptionPane.ERROR_MESSAGE
		);
		window.dispatchEvent(new WindowEvent(null, 0));
	}
}
