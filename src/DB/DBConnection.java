package DB;

import java.sql.*;
import java.util.Vector;
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

    // insert new row to DB
    public void insert(String TableName) {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            stat = conn.createStatement();
            
            if(TableName == "Employee") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                    + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                    + "`month`,`day`,`sales`,`comRate`) "
                    + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if(TableName == "Products") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                    + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                    + "`month`,`day`,`sales`,`comRate`) "
                    + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if(TableName == "Customers") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                    + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                    + "`month`,`day`,`sales`,`comRate`) "
                    + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if(TableName == "Manufacturers") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                    + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                    + "`month`,`day`,`sales`,`comRate`) "
                    + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if(TableName == "Sales") {
                String sql = "INSERT INTO `" + TableName + "`.`Employees`"
                    + "(`firstName`,`lastName`,`age`,`position`,`year`,"
                    + "`month`,`day`,`sales`,`comRate`) "
                    + "VALUES (`clark`,`kent`,`30`,`saler`,`1950`,`08`,`30`,`100`,`0.52`)";
            } else if(TableName == "Login") {
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
}
