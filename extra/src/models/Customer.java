package models;

import MySql.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.exceptions.RecordNotFoundException;

public class Customer extends Company
{
    //attributes
    private Address billing;
    private Address shipping;
    
    
    //getters and setters
    public Address getBilling() { return billing; }
    public void setBilling(Address billing) { this.billing = billing; }
    public Address getShipping() { return shipping; }
    public void setShipping(Address shipping) { this.shipping = shipping; }
    
    //constructors
    
    public Customer() 
    {
        super();
        this.billing = new Address();
        this.shipping = new Address();
    }
    
    public Customer(int id) throws RecordNotFoundException 
    {
        super();
         try {
            // query
            String query = "SELECT c.id, c.name, a1.id as id1, a1.streetName as streetname1, a1.exteriorNumber as ex1, "
                        + "a1.interiorNumber as in1, a2.id as id2, a2.streetName as streetname2, a2.exteriorNumber as ex2, "
                        + "a2.interiorNumber as in2\n" +
                            "FROM customers as c \n" +
                            "INNER JOIN addresses as a1 ON c.idBillingAddress = a1.id \n" +
                            "INNER JOIN addresses as a2 ON c.idShippingAddress = a2.id \n" +
                            "WHERE c.id = ?";
            // statement
            PreparedStatement statement = MySqlConnection.getConnection().prepareStatement(query);
            statement.setInt(1, id); //parameters
            ResultSet result = statement.executeQuery(); //execute command
            //read data
            if(result.next()) {
                super.setId(result.getInt("id"));
                super.setName(result.getString("name"));
                //pass values of fields to attributes
                Address billing = new Address(result.getString("streetname1"), result.getInt("ex1"), result.getString("in1"));
                Address shipping = new Address(result.getString("streetname2"), result.getInt("ex2"), result.getString("in2"));
                this.billing = billing;
                this.shipping = shipping;
            }
            else
                throw new RecordNotFoundException(id);
        }
        catch(SQLException ex) {
            System.out.println("SQL Exception : " + ex.getMessage());
        }
    }

    public Customer(int id, String name, Address billing, Address shipping) 
    {
        super(id, name);
        this.billing = billing;
        this.shipping = shipping;
    }
}
