import java.util.Scanner;
import java.util.logging.Handler;
import javax.management.modelmbean.ModelMBean;

public class SalaryManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    float indexSalary;
    int someHolidays;
    int overtime;
    int year;
    int month;

    @Override
    public void inputList() {
        // Input new list account
        if (MenuHandle.m < 0 && MenuHandle.n < 0) {
            MenuContent.printNoData();
        } else {
            for (int i = 0; i < MenuHandle.m; i++) {
                for (Account o : MenuHandle.listAccount) {
                    if (o.getEmployee().getIdEmp().equals(MenuHandle.listDepartments[i].getIdChief())) {
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("|  ==> Input info salary of Chief Of Department    |");
                        System.out.println("--------------------------------------------------------------");
                        System.out.print(" ==> Input year > ");
                        year = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input month > ");
                        month = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input indexSalary > ");
                        indexSalary = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input daysOff > ");
                        someHolidays = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input Overtime > ");
                        overtime = MenuHandle.getInputNumber();
                        o.getEmployee().netSalary(o, indexSalary, someHolidays, overtime, year, month);
                    }
                }

                for (int j = 0; j < MenuHandle.listDepartments[i].getMembers(); j++) {
                    String idEmp = MenuHandle.listDepartments[i].getIdEmployee()[j];
                    for (Account o : MenuHandle.listAccount) {
                        if (o.getEmployee().getIdEmp().equals(idEmp)) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.print("|  ==> Input info salary of employee                          |\n");
                            System.out.println("--------------------------------------------------------------");
                            System.out.print(" ==> Input year > ");
                            year = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input month > ");
                            month = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input indexSalary > ");
                            indexSalary = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input someHolidays > ");
                            someHolidays = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input overtime > ");
                            overtime = MenuHandle.getInputNumber();
                            o.getEmployee().netSalary(o, indexSalary, someHolidays, overtime, year, month);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void outputList() {
        for (Department d : MenuHandle.listDepartments) {
            System.out.print(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "\n|                                                                               %-144s|",
                    "List salary for employee of department " + d.getDepartmentName());
            System.out.println(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|",
                    "Id Employee", "Year", "January",
                    "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
                    "December");
            System.out.print(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Account account : MenuHandle.listAccount) {
                if (d.getIdChief().equalsIgnoreCase(account.getEmployee().getIdEmp())) {
                    account.getEmployee().outputSalary();
                }
            }
            for (Account account : MenuHandle.listAccount) {
                if (MenuHandle.checkIdOfDep(account.getEmployee().getIdEmp(), d.getDepartmentId()))
                    account.getEmployee().outputSalary();
            }
        }
    }

    @Override
    public void add() {
        String idEmpAdd;

    }

    @Override
    public void remove(String idRemove) {

    }

    @Override
    public void edit(String idEdit) {
        if (MenuHandle.n < 0)
            MenuContent.printNoData();
        else {
            System.out.print(" ==> Enter if employee to edit  ");
            idEdit = scanner.nextLine();
            for (Account o : MenuHandle.listAccount) {
                if (o.getEmployee().getIdEmp().equalsIgnoreCase(idEdit)) {
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("|  ==> Input info salary of employee                          |\n");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print(" ==> Input year > ");
                    year = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input month > ");
                    month = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input indexSalary > ");
                    indexSalary = MenuHandle.getInputNumberFloat();
                    System.out.print(" ==> Input someHolidays > ");
                    someHolidays = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input overtime > ");
                    overtime = MenuHandle.getInputNumber();
                    o.getEmployee().netSalary(o, indexSalary, someHolidays, overtime, year, month);
                }
            }
        }
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount("Salary", MenuHandle.n);
    }

    @Override
    public void find(String idFind) {
        if (MenuHandle.n < 0)
            MenuContent.printNoData();
        else {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|",
                    "Id Employee", "Year", "January",
                    "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
                    "December");
            System.out.print(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Enter if employee to edit");
            idFind = scanner.nextLine();
            for (Account o : MenuHandle.listAccount) {
                if (o.getEmployee().getIdEmp().equalsIgnoreCase(idFind)) {
                    o.getEmployee().outputSalary();
                }
            }
        }
    }
}