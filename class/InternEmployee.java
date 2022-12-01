import java.util.Scanner;

public class InternEmployee extends Employee {
    static Scanner scanner = new Scanner(System.in);

    public InternEmployee() {
    }

    public InternEmployee(String idEmp, String position) {
        super(idEmp, position);
    }

    public InternEmployee(String idEmp, String position, String name, int age, String gender, String email,
            String address, String phone) {
        super(idEmp, position, name, age, gender, email, address, phone);
    }

    public InternEmployee(String name, int age, String gender, String email, String address, String phone, String idEmp,
            String position, Contract contract) {
        super(name, age, gender, email, address, phone, idEmp, position, contract);
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

    @Override
    public String toString() {
        return "Official Employee" + "-" + getIdEmp() + "-" + getPosition() + "-" + getName() + "-" + getAge() + "-"
                + getGender() + "-" + getEmail() + "-" + getAddress() + "-" + getPhone();
    }
}
