package com.supinfo.supplay.gui;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class JT_Model extends AbstractTableModel {
	
	private Object[][] data;
	private String[] colHeaders;
	
	
	public JT_Model(Object[][] data, String[] columnHeaders)
	{
		this.data = data;
		this.colHeaders = columnHeaders;
	}
	
	@Override
	public int getColumnCount()
	{
		return colHeaders.length;
	}

	@Override
	public int getRowCount()
	{
		return data.length;
	}

	@Override
	public String getColumnName(int col) {
	    return colHeaders[col];
	}
	
	@Override
	public Object getValueAt(int row, int col)
	{
		if (row < 0 || row >= this.data.length || col < 0 || col >= this.colHeaders.length)
			return null;
		return data[row][col];
	}
	
	@Override
	public void setValueAt(Object value, int row, int col)
	{
		if (row < 0 || row >= this.data.length || col < 0 || col >= this.colHeaders.length)
		{
			data[row][col] = value;
			this.fireTableDataChanged();
		}
	}

}
