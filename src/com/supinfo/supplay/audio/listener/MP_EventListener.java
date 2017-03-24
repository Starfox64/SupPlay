package com.supinfo.supplay.audio.listener;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.supinfo.supplay.gui.Window;

import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;

public class MP_EventListener implements MediaPlayerEventListener {

	private Window window;
	
	public MP_EventListener(Window window)
	{
		this.window = window;
	}
	
	@Override
	public void finished(MediaPlayer mediaPlayer) {
		//play next file if there's one
		if (window.getModel().getRowCount() - 1 > window.getCurrentFile())
		{
			window.incCurrentFile();
			String file = (String) window.getModel().getRow(window.getCurrentFile())[3];
			window.getEMP().prepareMedia(file);
			window.getEMP().parseMedia();
			window.getEMP().playMedia(file);
			window.setTitle("SupPlay - " + window.getEMP().getMediaMeta().getTitle());
		}
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

	@Override
	public void backward(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buffering(MediaPlayer arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endOfSubItems(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forward(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lengthChanged(MediaPlayer arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaChanged(MediaPlayer arg0, libvlc_media_t arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaDurationChanged(MediaPlayer arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaFreed(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaMetaChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaParsedChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaStateChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mediaSubItemAdded(MediaPlayer arg0, libvlc_media_t arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newMedia(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void opening(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pausableChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paused(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playing(MediaPlayer arg0) {
		
	}

	@Override
	public void positionChanged(MediaPlayer arg0, float arg1) {
		window.getJPG().setValue(
				Math.min(100, Math.round(arg1 * 100))
		);
		window.getModel().setValueAt(
				secondsToHMS((int) window.getEMP().getLength() / 1000),
				window.getCurrentFile(),
				1);
		
	}

	private String secondsToHMS(int seconds)
	{
		int s = seconds % 60;
		int m = Math.round(seconds / 60);
		int h = Math.round(seconds / 3600);
		return String.format("%d:%02d:%02d", h, m, s);
	}
	
	@Override
	public void seekableChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void snapshotTaken(MediaPlayer arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopped(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subItemFinished(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subItemPlayed(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timeChanged(MediaPlayer arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void titleChanged(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void videoOutput(MediaPlayer arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
