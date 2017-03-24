package com.supinfo.supplay.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.supinfo.supplay.gui.Window;

public class JMI_OpenFileListener implements ActionListener {

	private Window window;
	
	public JMI_OpenFileListener(Window window)
	{
		this.window = window;
	}
	
	public String[] parseFileName(String file)
	{
		String[] parsedFile = new String[2];

		int i = file.lastIndexOf('.');
		parsedFile[0] = file.substring(0, i);
	    parsedFile[1] = file.substring(i+1);
		return parsedFile;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(new FileNameExtensionFilter(null, "wav", "mp3"));
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//put selected file into the grid
			String file = jfc.getSelectedFile().getAbsolutePath();
			String[] filename = parseFileName(jfc.getSelectedFile().getName());
			Object[] content = {filename[0], "-1", filename[1], file};
			window.getModel().addRow(content);
			content = null;
			filename = null;
			if (!window.getEMP().isPlaying())
			{
				window.getEMP().prepareMedia(file);
				window.getEMP().parseMedia();
				window.getEMP().playMedia(file);
				window.setTitle("SupPlay - " + window.getEMP().getMediaMeta().getTitle());
				window.incCurrentFile();
				window.getPlayButton().setIcon(
						new ImageIcon(this.getClass().getResource("../../img/pause-button.png"))
					);
			}
		}
	}

}
