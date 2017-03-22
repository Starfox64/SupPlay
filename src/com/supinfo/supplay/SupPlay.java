package com.supinfo.supplay;

import com.supinfo.supplay.gui.Window;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class SupPlay {

	public static void main(String[] args) {
		//SLF4J error messages are not error messages
		new NativeDiscovery().discover();
		Window w = new Window();
       
		
		
	}

}
