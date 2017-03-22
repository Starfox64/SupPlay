package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.supinfo.supplay.SupPlay;

public class JB_PlayPauseListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		SupPlay.MPC.getMediaPlayer().pause();
	}

}
