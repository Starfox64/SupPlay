package com.supinfo.supplay.gui.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.supinfo.supplay.gui.Window;

public class W_CloseListener extends WindowAdapter {

	private Window window;
	
	public W_CloseListener(Window window)
	{
		this.window = window;
	}
	
	@Override
	public void windowClosing(WindowEvent e)
	{
		window.getEMP().release();
		System.exit(0);
	}
	
}
