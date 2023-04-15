package StepDefinition;

import Pages.AddEmployeePage;
import Pages.EmployeeSearchPage;
import Pages.LoginPage;

public class PageInitializer {
public static LoginPage login;
public static AddEmployeePage addEmployeePage;

public static EmployeeSearchPage employeeSearchPage;
    public static void initializePageObjects(){
   login=new LoginPage();
 addEmployeePage=new AddEmployeePage();
 employeeSearchPage=new EmployeeSearchPage();

    }

}
