package com.supinfo.supplay.audio.listener;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.supinfo.supplay.SupPlay;

import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

public class MP_EventListener extends MediaPlayerEventAdapter {

	@Override
	public void finished(MediaPlayer mediaPlayer) {
		//play next file if there's one
	}
	
	@Override
	public void error(MediaPlayer mediaPlayer) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null,
						"Failed to read the file",
						"An Error Has Occured",
						JOptionPane.ERROR_MESSAGE
				);
				SupPlay.WINDOW.dispatchEvent(new WindowEvent(null, 0));
			}
		});
	}
}
