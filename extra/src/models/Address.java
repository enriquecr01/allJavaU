package models;

import MySql.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.exceptions.RecordNotFoundException;

public class Address 
{
    //attributes
    private String streetName;
    private int exteriorNumber;
    private String interiorNumber;
    
    //getter and setters
    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public int getExteriorNumber() { return exteriorNumber; }
    public void setExteriorNumber(int exteriorNumber) { this.exteriorNumber = exteriorNumber; }
    public String getInteriorNumber() { return interiorNumber; }
    public void setInteriorNumber(String interiorNumber) { this.interiorNumber = interiorNumber; }
    
    //constructors
    public Address() {
        this.streetName = "";
        this.exteriorNumber = 0;
        this.interiorNumber = "";
    }

    public Address(String streetName, int exteriorNumber, String interiorNumber) {
        this.streetName = streetName;
        this.exteriorNumber = exteriorNumber;
        this.interiorNumber = interiorNumber;
    }
    
    @Override
    public String toString()
    {
        return this.streetName + " " + this.exteriorNumber + " " + this.interiorNumber; 
    }
    
    
}
