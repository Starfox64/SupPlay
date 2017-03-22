package com.supinfo.supplay.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class JT_Model extends AbstractTableModel {
	
	private List<List<Object>> data;
	private String[] colHeaders;
	
	
	public JT_Model(List<List<Object>> data, String[] columnHeaders)
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
		return data.size();
	}

	@Override
	public String getColumnName(int col) {
	    return colHeaders[col];
	}
	
	@Override
	public Object getValueAt(int row, int col)
	{
		if (row < 0 || row >= this.data.size() || col < 0 || col >= this.colHeaders.length)
			return null;
		return data.get(row).get(col);
	}
	
	
	@Override
	public void setValueAt(Object value, int row, int col)
	{
		if (0 <= row && row < this.data.size() && 0 <= col && col < this.colHeaders.length)
		{
			data.get(row).set(col, value);
			
			this.fireTableDataChanged();
		}
	}
	
	public void addRow(List<Object> row)
	{
		data.add(row);
		this.fireTableRowsInserted(data.size() - 1, data.size() - 1);
	}
	

}
