import java.util.Scanner;

public class ChiefDepartment extends Employee {

    static Scanner scanner = new Scanner(System.in);

    public ChiefDepartment() {
    }

    public ChiefDepartment(String idEmp, String position) {
        super(idEmp, position);
    }

    public ChiefDepartment(String name, int age, String gender, String email, String address, String phone,
            Long[] salaryDiary, String idEmp, String position, Contract contract) {
        super(name, age, gender, email, address, phone, salaryDiary, idEmp, position, contract);
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void output() {
        super.output();
    }

    @Override
    public double netSalary(String idEmp) {
        return 0;
    }
}
