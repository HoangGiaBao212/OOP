import java.util.Scanner;

public class ChiefDepartment extends Employee {

    static Scanner scanner = new Scanner(System.in);

    private final Long baseSalary = (long) 600000;
    private final int overtimeSalary = 50000;

    public ChiefDepartment() {
    }

    public ChiefDepartment(String idEmp, String position) {
        super(idEmp, position);
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
    public double netSalary(Float indexSalary, int someHolidays, int overtime, int year, int month) {
        // Long totalSalary;
        int i = 0;
        while (true) {
            super.getSalaryDiary()[i] = new Long(i);
            if (super.getSalaryDiary()[i] == 0) {
                super.getSalaryDiary()[i] = (long) year;
                if (month == 1) {
                    i += 1;
                    super.getSalaryDiary()[i] = new Long(i);
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 2) {
                    i += 2;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 3) {
                    i += 3;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 4) {
                    i += 4;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 5) {
                    i += 5;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 6) {
                    i += 6;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 7) {
                    i += 7;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 8) {
                    i += 8;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 9) {
                    i += 9;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 10) {
                    i += 10;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 11) {
                    i += 11;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
                if (month == 12) {
                    i += 12;
                    super.getSalaryDiary()[i] = (long) (indexSalary * baseSalary * 26
                            + overtime * overtimeSalary - someHolidays * baseSalary);
                    break;
                }
            } else {
                i += 13;
            }
        }
        return super.getSalaryDiary()[i];
    }

    @Override
    public String toString() {
        return "Chief Of Department" + "-" + getIdEmp() + "-" + getPosition() + "-" + getName() + "-" + getAge() + "-"
                + getGender() + "-" + getEmail() + "-" + getAddress() + "-" + getPhone();
    }
}
