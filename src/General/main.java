/* OOP Assignment 3. Group: Ben, Jeff, Sergei.
* Sergei part: setting up DB in PHPMyAdmin, Create Sales and Customer Class, Setup basic GUI and classes
* Jeff part: create new tab for Sales and Admin, finish GUI
* Ben part: create event handlers, DB queries and validation, IO part
*  All ID's are generated inside DB.
*/
package General;

import HRPackage.*;
import GUI.*;
import DB.*;
import Manufacturers.*;
import Products.*;
import IO.*;
import Customers.*;
import Sales.*;
import java.lang.reflect.Method;
import java.util.*;
import javax.swing.JFrame;

public class main {
    
    // object customer that we need to check is logged customer admin or not
    public Customer customer;
    
    public static void main(String[] args) {
        // build login gui       
        LoginGUI loginScreen = new LoginGUI();
        loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginScreen.pack();
        loginScreen.setVisible(true);
        
        // add here an event that validate form
        // loginScreen.login();
        
        // if form is validated hide loginScreen and show basic GUI
//        loginScreen.setVisible(false);
//        GUI gui = new GUI();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.pack();
//        gui.setVisible(true);
    }
    
}
