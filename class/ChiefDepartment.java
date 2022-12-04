import java.util.Arrays;
import java.util.Scanner;

public class ChiefDepartment extends Employee {

    static Scanner scanner = new Scanner(System.in);

    private final double baseSalary = 600000;
    private final int overtimeSalary = 50000;

    public ChiefDepartment() {
    }

    public ChiefDepartment(String idEmp, String position) {
        super(idEmp, position);
    }

    public ChiefDepartment(long[] salaryDiary) {
        super(salaryDiary);
    }

    public ChiefDepartment(String idEmp, String position, String name, int age, String gender, String email,
            String address, String phone) {
        super(idEmp, position, name, age, gender, email, address, phone);
    }

    public ChiefDepartment(String name, int age, String gender, String email, String address, String phone,
            String idEmp, String position, Contract contract) {
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
    public void netSalary(Account account, Float indexSalary, int someHolidays, int overtime, int year, int month) {
        int i = 0;
        for (Account o : MenuHandle.listAccount) {
            System.out.println(o.getEmployee().getSalaryDiary().length);
            while (true) {
                if (o.getEmployee().getIdEmp().equalsIgnoreCase(account.getEmployee().getIdEmp())) {
                    // o.getEmployee().salaryDiary = Arrays.copyOf(o.getEmployee().salaryDiary, i +
                    // 1);
                    if (o.getEmployee().getSalaryDiary()[i] == 0) {
                        o.getEmployee().salaryDiary = Arrays.copyOf(o.getEmployee().salaryDiary, i + 13);
                        o.getEmployee().getSalaryDiary()[i] = year;
                        if (month == 1)
                            i += 1;
                        if (month == 2)
                            i += 2;
                        if (month == 3)
                            i += 3;
                        if (month == 4)
                            i += 4;
                        if (month == 5)
                            i += 5;
                        if (month == 6)
                            i += 6;
                        if (month == 7)
                            i += 7;
                        if (month == 8)
                            i += 8;
                        if (month == 9)
                            i += 9;
                        if (month == 10)
                            i += 10;
                        if (month == 11)
                            i += 11;
                        if (month == 12)
                            i += 12;
                        o.getEmployee()
                                .getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                                        - someHolidays * baseSalary);
                        break;
                    }
                    if (o.getEmployee().getSalaryDiary()[i] == year) {
                        // o.getEmployee().salaryDiary = Arrays.copyOf(o.getEmployee().salaryDiary, i +
                        // 13);
                        if (month == 1)
                            i += 1;
                        if (month == 2)
                            i += 2;
                        System.out.println(o.getEmployee().getSalaryDiary()[i]);
                        if (month == 3)
                            i += 3;
                        if (month == 4)
                            i += 4;
                        if (month == 5)
                            i += 5;
                        if (month == 6)
                            i += 6;
                        if (month == 7)
                            i += 7;
                        if (month == 8)
                            i += 8;
                        if (month == 9)
                            i += 9;
                        if (month == 10)
                            i += 10;
                        if (month == 11)
                            i += 11;
                        if (month == 12)
                            i += 12;
                        o.getEmployee()
                                .getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                                        - someHolidays * baseSalary);
                        break;
                    } else
                        i += 13;
                } else
                    break;
            }
        }

    }

    @Override
    public void outputSalary() {
        System.out.printf("\n|%-15s|", getIdEmp());
        // System.out.println(getSalaryDiary().length);
        for (int i = 0; i < getSalaryDiary().length - 1; i++) {
            if (getSalaryDiary()[i] == 0 && i % 13 == 0 && i != 0)
                break;
            System.out.printf("%-15s|", getSalaryDiary()[i]);
            for (int j = 1; j <= 12; j++) {
                i++;
                System.out.printf("%-15s|", getSalaryDiary()[i]);
            }
        }
    }

    @Override
    public String toStringSalary(String id) {
        String str = "";
        int i = 0;
        for (Account o : MenuHandle.listAccount) {
            while (i < o.getEmployee().getSalaryDiary().length) {
                if (o.getEmployee().getIdEmp().equalsIgnoreCase(id)) {
                    if (o.getEmployee().getSalaryDiary()[i] == 0 && i % 13 == 0 && i != 0)
                        break;
                    str += "-" + Long.toString(o.getEmployee().getSalaryDiary()[i]);
                    i++;
                } else
                    break;
            }
        }
        return getIdEmp() + str;
    }

    @Override
    public String toString() {
        return "Chief Of Department" + "-" + getIdEmp() + "-" + getPosition() + "-" + getName() + "-" + getAge() + "-"
                + getGender() + "-" + getEmail() + "-" + getAddress() + "-" + getPhone();
    }

}
