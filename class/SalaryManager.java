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
    // indexSalary*baseSalary*26 + giolamthem*luonglamthem - baseSalary*someHolidays

    /*
     * 0 là năm
     * 1-> 12 thánh (lương)
     * 13
     * 14->25
     * int yearCount = 1;
     * for (int i=1;;i++){
     * yearCount++;
     * sout(nhap du lieu nam )
     * input ==> i;
     * i++;
     * sout(nhap thang 1)
     * input ==> i;
     * i++;
     * ...........
     * 
     * if (yearCount = bienchousernhapvao) break;
     * 
     * }
     * [nam][thang 1][][][][][][] i+12
     * i+12+1
     * i+12+2
     * if(a[i+12] == namnhapvao)
     * if (a[i+12+1] == thang1) xuat thang1
     * 
     * 
     */

    @Override
    public void inputList() {
        // Input new list account
        if (MenuHandle.m < 0 && MenuHandle.n < 0) {
            MenuContent.printNoData();
        } else {
            for (int i = 0; i < MenuHandle.m; i++) {
                for (Account o : MenuHandle.listAccount) {
                    if (o.getEmployee().getIdEmp().equals(MenuHandle.listDepartments[i].getDepartmentId())) {
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
                        o.getEmployee().netSalary(indexSalary, someHolidays, overtime, year, month);
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
                            o.getEmployee().netSalary(indexSalary, someHolidays, overtime, year, month);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void outputList() {
        for (Account account : MenuHandle.listAccount) {
            System.out.println("LIST SALARY");
            account.getEmployee().outputSalary();
        }
        // for (int i = 0; i < 12; i++) {
        // System.out.println(MenuHandle.listAccount[0].getEmployee().salaryDiary[i]);
        // }
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

    }

    @Override
    public void statistics() {
        MenuContent.quantityCount("Salary", MenuHandle.n);
    }

    @Override
    public void find(String idEmp) {
        // TODO Auto-generated method stub

    }
}