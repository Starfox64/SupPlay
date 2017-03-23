package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.supinfo.supplay.gui.Window;

public class JMI_OpenFileListener implements ActionListener {

	private Window window;
	
	public JMI_OpenFileListener(Window window)
	{
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(new FileNameExtensionFilter(null, "wav", "mp3"));
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//put selected file into the grid
			String file = jfc.getSelectedFile().getAbsolutePath();
			window.getEMP().prepareMedia(file);
			window.getEMP().parseMedia();
			window.getEMP().playMedia(file);
			window.setTitle("SupPlay - " + window.getEMP().getMediaMeta().getTitle());
		}
	}

}
