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
    public void netSalary(Float indexSalary, int someHolidays, int overtime, int year, int month) {
        int i = 0;
        while (true) {
            for (Account o : MenuHandle.listAccount) {
                o.getEmployee().setSalaryDiary(salaryDiary);
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
            }
            break;
        }

    }

    @Override
    public void outputSalary() {
        int i = 0;
        for (Account o : MenuHandle.listAccount) {
            while (i <= 12) {
                System.out.println(o.getEmployee().getSalaryDiary()[i]);
                i++;
            }
        }
    }

    @Override
    public String toStringSalary() {
        String str = "";
        int i = 0;
        for (Account o : MenuHandle.listAccount) {
            while (i <= 12) {
                str += "-" + Long.toString(o.getEmployee().getSalaryDiary()[i]);
                i++;
            }
        }
        return getIdEmp() + str;
    }

    @Override
    public String toString() {
        return "Official Employee" + "-" + getIdEmp() + "-" + getPosition() + "-" + getName() + "-" + getAge() + "-"
                + getGender() + "-" + getEmail() + "-" + getAddress() + "-" + getPhone();
    }

}
