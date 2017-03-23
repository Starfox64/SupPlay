package com.supinfo.supplay;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import com.sun.jna.NativeLibrary;
import com.supinfo.supplay.gui.Window;

import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class SupPlay {

	private static final String PATH = "lib";
	
	public static void main(String[] args) {
		//SLF4J error messages are not error messages
		
		try {
		     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		     Logger.getLogger(SupPlay.class.getName()).log(Level.SEVERE, null, ex);
		}
		NativeLibrary.addSearchPath("libvlc", PATH);
		System.setProperty("jna.library.path", PATH);
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), PATH);
		
		new Window();
	}

}
