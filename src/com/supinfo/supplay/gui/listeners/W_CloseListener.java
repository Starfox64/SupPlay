package com.supinfo.supplay.gui.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.supinfo.supplay.gui.Window;

public class W_CloseListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e)
	{
		Window.getMPC().release();
		System.exit(0);
	}
	
}
