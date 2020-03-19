package models;

import MySql.MySqlConnection;
import models.exceptions.RecordNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Country {
    //attributes
    private String id;
    private String name;
    
    //getters and setters
    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    
    //contructors
    public Country() {
        this.id = "";
        this.name = "";
    }
    public Country(String id) throws RecordNotFoundException {
        try {
            // query
            String query = "select id, names from countries where id = ?";
            // statement
            PreparedStatement statement = MySqlConnection.getConnection().prepareStatement(query);
            statement.setString(1, id); //parameters
            ResultSet result = statement.executeQuery(); //execute command
            //read data
            if(result.next()) {
                //pass values of fields to attributes
                this.id = result.getString("id");
                this.name = result.getString("names");
            }
            else
                throw new RecordNotFoundException(id);
        }
        catch(SQLException ex) {
            System.out.println("SQL Exception : " + ex.getMessage());
        }
    }
    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
}
