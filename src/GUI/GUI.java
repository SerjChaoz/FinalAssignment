package GUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    // panels
    private JPanel greetingPanel, mainPanel = new JPanel(), employeeTab,
            employeePanel, employeeSearchPanel, hourlyEmpTab, salaryEmpTab,
            commissionEmpTab, productTab, productPanel, manufacturerPanel,
            productSearchPanel, exitPanel;
    // tabs
    private JTabbedPane mainTabs, employeeTypeTab;

    // main labels
    private JLabel helloLbl;

    // labels for employee tab
    private JLabel firstNameLbl, lastNameLbl, addressLbl, phoneNumberLbl,
            yearLbl, monthLbl, dayLbl, weeklySalaryLbl, hoursLbl, hourRateLbl,
            salesLbl, commissionRateLbl, baseSalaryLbl, searchEmpResultsLbl,
            searchProductResultsLbl;

    // text boxes for employee tab
    private JTextField firstNameTxt = new JTextField(15),
            lastNameTxt = new JTextField(15),
            addressTxt = new JTextField(15),
            phoneNumberTxt = new JTextField(15),
            yearTxt = new JTextField(15),
            monthTxt = new JTextField(15),
            dayTxt = new JTextField(15),
            searchEmployeeTxt = new JTextField(15),
            weeklySalaryTxt = new JTextField(15),
            hoursTxt = new JTextField(15),
            hourRateTxt = new JTextField(15),
            salesTxt = new JTextField(15),
            commissionRateTxt = new JTextField(15),
            baseSalaryTxt = new JTextField(15);

    // labels for product tab
    private JLabel productNameLbl, productPriceLbl, manufacturerNameLbl,
            manufacturerCountryLbl, searchProductLbl;
    // text boxes for product tab
    private JTextField productNameTxt = new JTextField(15),
            productPriceTxt = new JTextField(15),
            manufacturerNameTxt = new JTextField(15),
            manufacturerCountryTxt = new JTextField(15),
            searchProductTxt = new JTextField(15);

    // textareas for search results
    private JTextArea searchEmpResults, searchProductResults;

    // buttons
    private JButton createHourlyEmployeeBtn, createSalaryEmployeeBtn,
            createCommEmployeeBtn, createProductBtn, searchEmployeeBtn,
            searchProductBtn, exitBtn;

    // form font
    private Font mainFont = new Font("Verdana", Font.PLAIN, 14);

    // form border
    private Border mainBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

    // interface constructor
    public GUI() {

        // set title layout and 
        super("Assignment 3.");
        setLayout(new FlowLayout());

        // create tabs
        mainTabs = new JTabbedPane();

        // create main panels
        buildGreetingsPanel("Welcome to Assignment 3.");
        buildEmployeeTab();
        buildProductTab();
        buildExitPanel();

        // add tabs
        mainTabs.addTab("Employee", null, employeeTab, "Employee");
        mainTabs.addTab("Products", null, productTab, "Products");

        // add subpanels to main panel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(greetingPanel, BorderLayout.NORTH);
        mainPanel.add(mainTabs, BorderLayout.CENTER);
        mainPanel.add(exitPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    // build panels 
    // build greeting panel
    private void buildGreetingsPanel(String greetMessage) {
        greetingPanel = new JPanel();
        helloLbl = new JLabel(greetMessage);
        helloLbl.setFont(mainFont);
        greetingPanel.add(helloLbl);
        greetingPanel.setBorder(mainBorder);
    }

    // build employee tab and subpanels
    private void buildEmployeeTab() {
        // create tab
        employeeTab = new JPanel();
        buildEmployeePanel();
        buildEmployeeTypeTab();
        buildEmployeeSearchPanel();

        // set layout and add all subpanels to employee tab
        employeeTab.setLayout(new BorderLayout());
        employeeTab.add(employeePanel, BorderLayout.NORTH);
        employeeTab.add(employeeTypeTab, BorderLayout.CENTER);
        employeeTab.add(employeeSearchPanel, BorderLayout.SOUTH);
    }

    private void buildEmployeePanel() {
        // create new panel
        employeePanel = new JPanel();
        // set grid
        employeePanel.setLayout(new GridLayout(7, 2));
        // set border
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee info"));
        // set labels
        firstNameLbl = new JLabel("First Name");
        lastNameLbl = new JLabel("Last Name");
        addressLbl = new JLabel("Address");
        phoneNumberLbl = new JLabel("Phone Number");
        yearLbl = new JLabel("Year of birth");
        monthLbl = new JLabel("Month of birth");
        dayLbl = new JLabel("Day of birth");

        // add everything to panel
        employeePanel.add(firstNameLbl);
        employeePanel.add(firstNameTxt);
        employeePanel.add(lastNameLbl);
        employeePanel.add(lastNameTxt);
        employeePanel.add(addressLbl);
        employeePanel.add(addressTxt);
        employeePanel.add(phoneNumberLbl);
        employeePanel.add(phoneNumberTxt);
        employeePanel.add(yearLbl);
        employeePanel.add(yearTxt);
        employeePanel.add(monthLbl);
        employeePanel.add(monthTxt);
        employeePanel.add(dayLbl);
        employeePanel.add(dayTxt);
    }

    private void buildEmployeeTypeTab() {
        // create new tabs
        employeeTypeTab = new JTabbedPane();
        buildHourlyEmployeePanel();
        buildSalaryEmployeePanel();
        buildCommissionEmployeePanel();
        // add panels to tabs
        employeeTypeTab.addTab("Hourly Emp", null, hourlyEmpTab, "Hourly Emp");
        employeeTypeTab.addTab("Salary Emp", null, salaryEmpTab, "Salary Emp");
        employeeTypeTab.addTab("Commission Emp", null, commissionEmpTab, "Commission Emp");
    }

    // build three subpanels for each employee type
    private void buildHourlyEmployeePanel() {
        // create new panel
        hourlyEmpTab = new JPanel();
        // set grid
        hourlyEmpTab.setLayout(new GridLayout(3, 2));
        // set border
        hourlyEmpTab.setBorder(BorderFactory.createTitledBorder("Create Hourly Employee"));
        // set labels
        hoursLbl = new JLabel("Hours");
        hourRateLbl = new JLabel("Hour Rate");
        // create button
        createHourlyEmployeeBtn = new JButton("Create Hourly Employee");
        // add everything to panel
        hourlyEmpTab.add(hoursLbl);
        hourlyEmpTab.add(hoursTxt);
        hourlyEmpTab.add(hourRateLbl);
        hourlyEmpTab.add(hourRateTxt);
        hourlyEmpTab.add(createHourlyEmployeeBtn);

    }

    private void buildSalaryEmployeePanel() {
        // create new panel
        salaryEmpTab = new JPanel();
        // set grid
        salaryEmpTab.setLayout(new GridLayout(2, 2));
        // set border
        salaryEmpTab.setBorder(BorderFactory.createTitledBorder("Create Salary Employee"));
        // set labels
        weeklySalaryLbl = new JLabel("Weekly salary");
        // create button
        createSalaryEmployeeBtn = new JButton("Create Salary Employee");
        // add everything to panel
        salaryEmpTab.add(weeklySalaryLbl);
        salaryEmpTab.add(weeklySalaryTxt);
        salaryEmpTab.add(createSalaryEmployeeBtn);
    }

    private void buildCommissionEmployeePanel() {
        // create new panel
        commissionEmpTab = new JPanel();
        // set grid
        commissionEmpTab.setLayout(new GridLayout(4, 2));
        // set border
        commissionEmpTab.setBorder(BorderFactory.createTitledBorder("Create Commission Employee"));
        // set labels
        salesLbl = new JLabel("Sales");
        commissionRateLbl = new JLabel("Commission Rate");
        baseSalaryLbl = new JLabel("Base salary");
        // create button
        createCommEmployeeBtn = new JButton("Create Commission Employee");
        // add everything to panel
        commissionEmpTab.add(salesLbl);
        commissionEmpTab.add(salesTxt);
        commissionEmpTab.add(commissionRateLbl);
        commissionEmpTab.add(commissionRateTxt);
        commissionEmpTab.add(baseSalaryLbl);
        commissionEmpTab.add(baseSalaryTxt);
        commissionEmpTab.add(createCommEmployeeBtn);
    }

    private void buildEmployeeSearchPanel() {
        // create new panel
        employeeSearchPanel = new JPanel();
        // set grid
        employeeSearchPanel.setLayout(new GridLayout(4, 1));
        // set border
        employeeSearchPanel.setBorder(BorderFactory.createTitledBorder("Search Employee"));
        // set labels
        searchEmpResultsLbl = new JLabel("Search results:");
        // create text area for search results
        searchEmpResults = new JTextArea(3, 20);
        // create button
        searchEmployeeBtn = new JButton("Search");
        // add everything to panel
        employeeSearchPanel.add(searchEmployeeTxt);
        employeeSearchPanel.add(searchEmployeeBtn);
        employeeSearchPanel.add(searchEmpResultsLbl);
        employeeSearchPanel.add(searchEmpResults);
    }

    // build product tab and subpanels
    private void buildProductTab() {
        // create new tab
        productTab = new JPanel();
        buildProductPanel();
        buildManufacturerPanel();
        buildProductSearchPanel();
        // set layout and add all subpanels to product tab
        productTab.setLayout(new BorderLayout());
        productTab.add(productPanel, BorderLayout.NORTH);
        productTab.add(manufacturerPanel, BorderLayout.CENTER);
        productTab.add(productSearchPanel, BorderLayout.SOUTH);

    }

    private void buildProductPanel() {
        // create new panel
        productPanel = new JPanel();
        // set grid
        productPanel.setLayout(new GridLayout(2, 2));
        // set border
        productPanel.setBorder(BorderFactory.createTitledBorder("Product basic info"));
        // set labels
        productNameLbl = new JLabel("Product name");
        productPriceLbl = new JLabel("Price");

        // add everything to panel
        productPanel.add(productNameLbl);
        productPanel.add(productNameTxt);
        productPanel.add(productPriceLbl);
        productPanel.add(productPriceTxt);

    }

    private void buildManufacturerPanel() {
        // create new panel
        manufacturerPanel = new JPanel();
        // set grid
        manufacturerPanel.setLayout(new GridLayout(5, 1));
        // set border
        manufacturerPanel.setBorder(BorderFactory.createTitledBorder("Manufacturer info"));
        // set labels
        manufacturerNameLbl = new JLabel("Manufacturer name");
        manufacturerCountryLbl = new JLabel("Country");

        // create product button
        createProductBtn = new JButton("Create product");

        // add everything to panel
        manufacturerPanel.add(manufacturerNameLbl);
        manufacturerPanel.add(manufacturerNameTxt);
        manufacturerPanel.add(manufacturerCountryLbl);
        manufacturerPanel.add(manufacturerCountryTxt);
        manufacturerPanel.add(createProductBtn);

    }

    private void buildProductSearchPanel() {
        // create new panel
        productSearchPanel = new JPanel();
        // set grid
        productSearchPanel.setLayout(new GridLayout(4, 1));
        // set border
        productSearchPanel.setBorder(BorderFactory.createTitledBorder("Search product by name"));
        // set labels
        searchProductResultsLbl = new JLabel("Search results:");
        // create search button
        searchProductBtn = new JButton("Search");
        // create text area for search results
        searchProductResults = new JTextArea(3, 20);

        // add everything to panel
        productSearchPanel.add(searchProductTxt);
        productSearchPanel.add(searchProductBtn);
        productSearchPanel.add(searchProductResultsLbl);
        productSearchPanel.add(searchProductResults);
    }

    // build bottom panel with exit button
    private void buildExitPanel() {
        exitPanel = new JPanel();
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ExitButtonListener());
        exitPanel.add(exitBtn);
    }

    // event handlers
    // close form
    private class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // are you sure box
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
    }

}
