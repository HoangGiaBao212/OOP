import java.util.Scanner;

import javax.management.modelmbean.ModelMBean;

public class SalaryManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    float indexSalary;
    int someHolidays;
    int overtime;
    // indexSalary*baseSalary*26 + giolamthem*luonglamthem - baseSalary*someHolidays

    /*
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

    }

    @Override
    public void outputList() {
        System.out.println(Handle.n);
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------");

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
        MenuContent.quantityCount("Salary", Handle.n);
    }

    @Override
    public void find(String idEmp) {
        // TODO Auto-generated method stub

    }
}