package com.supinfo.supplay.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JMI_OpenFileListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(new FileNameExtensionFilter(null, "wav", "mp3"));
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//put selected file into the grid
			Window.getTable().getModel().ad;
		}
	}

}
