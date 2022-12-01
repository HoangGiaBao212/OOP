import java.util.Scanner;

public class OfficialEmployee extends Employee {

    static Scanner scanner = new Scanner(System.in);
    private static int coefficientsSalary = 2;

    public OfficialEmployee() {
    }

    public OfficialEmployee(String idEmp, String position) {
        super(idEmp, position);
    }

    public OfficialEmployee(String name, int age, String gender, String email, String address, String phone,
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
