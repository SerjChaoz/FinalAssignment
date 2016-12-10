package HRPackage;

public class ServiceClass {
    private static int _employeeId = 10000;
    
    public static int getEmployeeID() {
        return ++ _employeeId;
    }    
}
