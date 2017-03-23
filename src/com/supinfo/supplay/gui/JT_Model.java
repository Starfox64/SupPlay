package com.supinfo.supplay.gui;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class JT_Model extends AbstractTableModel {
	
	private Object[][] data;
	private String[] colHeaders;
	private int size;
	
	
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
		if (0 <= row && row < this.data.length && 0 <= col && col < this.colHeaders.length)
		{
			data[row][col] = value;
			
			this.fireTableDataChanged();
		}
	}
	
	public void addRow(Object[] row)
	{
		Object[][] temp = data;
		data = new Object[data.length + 1][colHeaders.length];
		for (int line = 0; line < temp.length; line++)
		{
			for (int col = 0; col < colHeaders.length; col++)
				data[line][col] = temp[line][col];
		}
		temp = null;
		data[data.length - 1] = row;
		this.fireTableRowsInserted(data.length - 1, data.length - 1);
	}
	

}
