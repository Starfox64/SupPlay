package com.supinfo.supplay.gui.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.supinfo.supplay.SupPlay;

public class W_CloseListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e)
	{
		SupPlay.MPC.release();
		System.exit(0);
	}
	
}
