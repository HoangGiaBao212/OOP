import java.util.Scanner;

public class OfficialEmployee extends Employee {

    static Scanner scanner = new Scanner(System.in);

    private final Long baseSalary = (long) 550000;
    private final int overtimeSalary = 25000;

    public OfficialEmployee() {
    }

    public OfficialEmployee(String idEmp, String position) {
        super(idEmp, position);
    }

    public OfficialEmployee(String idEmp, String position, String name, int age, String gender, String email,
            String address, String phone) {
        super(idEmp, position, name, age, gender, email, address, phone);
    }

    public OfficialEmployee(String name, int age, String gender, String email, String address, String phone,
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
    public Long netSalary(Float indexSalary, int someHolidays, int overtime, int year, int month) {
        // Long totalSalary;
        int i = 0;
        while (true) {
            salaryDiary = new long[i + 12];
            if (salaryDiary[i] == 0) {
                salaryDiary[i] = year;
                if (month == 1) {
                    i += 1;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 2) {
                    i += 2;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 3) {
                    i += 3;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 4) {
                    i += 4;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 5) {
                    i += 5;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 6) {
                    i += 6;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 7) {
                    i += 7;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 8) {
                    i += 8;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 9) {
                    i += 9;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 10) {
                    i += 10;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 11) {
                    i += 11;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
                if (month == 12) {
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }
            } else {
                i += 13;
            }
        }
        return (long) salaryDiary[i];
    }

    @Override
    public String toString() {
        return "Official Employee" + "-" + getIdEmp() + "-" + getPosition() + "-" + getName() + "-" + getAge() + "-"
                + getGender() + "-" + getEmail() + "-" + getAddress() + "-" + getPhone();
    }

}
