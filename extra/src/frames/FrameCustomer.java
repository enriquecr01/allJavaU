package frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import models.Customer;
import models.exceptions.RecordNotFoundException;


public class FrameCustomer 
{
    //controls
    JFrame frame = new JFrame("Country");
    JPanel panelControls = new JPanel();
    JLabel labelId = new JLabel("Id:");
    JTextField textId = new JTextField(15);
    JLabel labelName = new JLabel("Name:");
    JTextField textName = new JTextField(15);
    JLabel labelBilling = new JLabel("Billing Address:");
    JTextField textBilling = new JTextField(15);
    JLabel labelShipping = new JLabel("Shipping Address:");
    JTextField textShipping = new JTextField(15);
    JButton buttonSearch = new JButton("Search", new ImageIcon("icons/search.png"));
    JPanel panelButtons = new JPanel();
    JButton buttonCancel = new JButton("Cancel", new ImageIcon("icons/cancel.png"));
    
    //constructor
    public FrameCustomer() {
        this.frame.setSize(450, 250); //size (width, height)
        this.frame.setLocationRelativeTo(null); //center the frame in the screen
        this.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //content pane
        Container container = frame.getContentPane();
        //layouts
        container.setLayout(new BorderLayout());
        panelControls.setLayout(new GridBagLayout());
        panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //add controls to panel
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 0, 0); //margins between controls
        c.weightx = 0.5;
        c.anchor = GridBagConstraints.WEST; //align to left
        c.gridy = 0; c.gridx = 0; panelControls.add(labelId, c);
        c.gridy = 0; c.gridx = 1; panelControls.add(textId, c);
        c.gridy = 0; c.gridx = 2; panelControls.add(buttonSearch, c);
        c.gridy = 1; c.gridx = 0; panelControls.add(labelName, c);
        c.gridy = 1; c.gridx = 1; panelControls.add(textName, c);
        c.gridy = 2; c.gridx = 0; panelControls.add(labelBilling, c);
        c.gridy = 2; c.gridx = 1; panelControls.add(textBilling, c);
        c.gridy = 3; c.gridx = 0; panelControls.add(labelShipping, c);
        c.gridy = 3; c.gridx = 1; panelControls.add(textShipping, c);
        //add the panel to the container
        container.add(panelControls, BorderLayout.NORTH);
        //disable text fields
        textName.setEnabled(false);
        textBilling.setEnabled(false);
        textShipping.setEnabled(false);
        //set button alignment
        buttonSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
        buttonSearch.setVerticalTextPosition(SwingConstants.CENTER);        
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setVerticalTextPosition(SwingConstants.BOTTOM);        
        //add the buttons to the panel
        panelButtons.add(buttonCancel);
        //add panel to the container
        container.add(panelButtons, BorderLayout.SOUTH);
        //event handlers
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
    }
    
    //show frame
    public void show() {
        this.frame.setVisible(true); 
    }
    
    //search button
    private void search() {
        try {
            int id = Integer.parseInt(textId.getText());
            Customer c = new Customer(id);
            textName.setText(c.getName());
            textBilling.setText(c.getBilling().toString());
            textShipping.setText(c.getShipping().toString());
        } 
        catch (RecordNotFoundException ex) {
            JOptionPane.showMessageDialog(this.frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //close application
    private void close() {
        if(JOptionPane.showConfirmDialog(
                this.frame, "Exit Application?", "Confirm", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
