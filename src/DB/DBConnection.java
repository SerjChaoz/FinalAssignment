// Class that contain DB connection variables and all queries
// All ID's are generated inside DB, so never add ID for INSERT statements.
package DB;

import Customers.Customer;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// class that store connection variables
public class DBConnection {

    Statement stat = null;
    Connection conn = null;
    ResultSet rs = null;
    final String DB_URL
            = "jdbc:mysql://sql.computerstudi.es:3306/gc200325005";
    final String DB_Username = "gc200325005";
    final String DB_Password = "nMWC7cP-";
    
    
    public Customer userLogged;

    // insert new row to DB
    public void insert(String TableName) {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            stat = conn.createStatement();

            if (TableName == "Employee") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                        + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                        + "`month`,`day`,`sales`,`comRate`) "
                        + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if (TableName == "Products") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                        + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                        + "`month`,`day`,`sales`,`comRate`) "
                        + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if (TableName == "Customers") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                        + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                        + "`month`,`day`,`sales`,`comRate`) "
                        + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if (TableName == "Manufacturers") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                        + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                        + "`month`,`day`,`sales`,`comRate`) "
                        + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if (TableName == "Sales") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                        + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                        + "`month`,`day`,`sales`,`comRate`) "
                        + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if (TableName == "Login") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                        + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                        + "`month`,`day`,`sales`,`comRate`) "
                        + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else {
                String sql = null;
            }

        } catch (SQLException err) {

        }
    }

    // select data from DB
    public void select(String TableName) {

    }

    // update row at DB
    public void update(String TableName, int rowID, Object obj) {

    }

    // delete row from DB
    public void delete(String TableName, int rowID) {

    }

    // store information in vector object
    public static DefaultTableModel buildTBModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // get the column names and store in a Vector
        Vector<String> columnNames = new Vector<String>();
        // column count
        int columnCount = metaData.getColumnCount();

        // loop to build the column names
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        // create the Vector to hold the data (Vectoe of Vectors)
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

        // go throught the resultset
        while (rs.next()) {
            // this will store each row
            Vector<Object> rowVector = new Vector<Object>();
            // loop through the result set and get each object
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                rowVector.add(rs.getObject(colIndex));
            }
            tableData.add(rowVector);
        }

        // return
        return new DefaultTableModel(tableData, columnNames);
    }

    // here is the method that will try to select user from Customers table
    // if user exists it return true and insert new record at Login table
    public boolean systemLogin(String login, String password) {
        int dbLoopCounter = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            if (conn != null) {
                // create the statement object that will manipulate with DB
                stat = conn.createStatement();
                rs = stat.executeQuery("SELECT * FROM Login WHERE login = `" + 
                        login + "` AND password = `" + password + "` LIMIT 1");
                
                if(rs != null) {
                    // create customer object, we need to move it to another location,
                    // not the best place to create customer object
                    userLogged = new Customer(rs.getString("login"),rs.getInt("custID"),rs.getBoolean("admin"));    
                } else {
                        JOptionPane.showMessageDialog(null, "Your Credentials were invalid. Please try again!");
                }
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Your Credentials were invalid. Please try again!");
            dbLoopCounter++;

            if (dbLoopCounter > 2) {
                JOptionPane.showMessageDialog(null, "Failure to authenticate to database. System will exit.");
                System.exit(0);
            }
        }
        
        return false;
    }
}
