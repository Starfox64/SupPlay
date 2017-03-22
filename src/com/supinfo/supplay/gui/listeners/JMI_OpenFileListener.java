package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.supinfo.supplay.SupPlay;

public class JMI_OpenFileListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(new FileNameExtensionFilter(null, "wav", "mp3"));
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//put selected file into the grid
			String file = jfc.getSelectedFile().getAbsolutePath();
			SupPlay.MPC.getMediaPlayer().prepareMedia(file);
			SupPlay.MPC.getMediaPlayer().parseMedia();
			SupPlay.MPC.getMediaPlayer().playMedia(file);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					SupPlay.WINDOW.setTitle(
							"SupPlay - " +
							SupPlay.MPC.getMediaPlayer().getMediaMeta().getTitle()
					);
				}
			});
		}
	}

}
