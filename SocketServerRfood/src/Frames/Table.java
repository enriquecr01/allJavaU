package Frames;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Table 
{
    String nombresDeColumna[] = { "MAC Device", "Date", "Hour", "Cans Inserted", "Weight", "Type of food", "Dispensed food", "Message" };
        
    JFrame frame = new JFrame("Container History");
    
    JPanel panelGrid = new JPanel();
    
    JTable table = new JTable();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    JScrollPane scrollPane;
    
    JPanel panelButtons = new JPanel();
    JLabel label = new JLabel("nada");
    
    public JLabel getLabel() { return label; }
    
    public Table()
    {
        modelo = new DefaultTableModel(null, nombresDeColumna); 
        
        JTable table = new JTable(modelo);
        Container container = frame.getContentPane();
        scrollPane = new JScrollPane(table);
        panelButtons.add(label, BorderLayout.PAGE_START);
        panelGrid.add(scrollPane, BorderLayout.CENTER);
        
        container.add(panelButtons, BorderLayout.PAGE_START);
        container.add(panelGrid, BorderLayout.SOUTH);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // añadimos la tabla
        frame.add(scrollPane);
        // tamaño
        frame.setSize(700, 300);
    }
    
    public void add(String[] newRow)
    {
        modelo.addRow(newRow);
        modelo.fireTableDataChanged();
    }
    
    public void show()
    {
        this.frame.setVisible(true);
    }
}
