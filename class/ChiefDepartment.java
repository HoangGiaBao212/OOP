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
    public Long netSalary(Float indexSalary, int someHolidays, int overtime, int year, int month) {
        // Long totalSalary;
        int i = -1;
        while (true) {
            i++;
            salaryDiary = new long[i + 14];
            if (salaryDiary[i] == 0) {
                salaryDiary[i] = year;
                if (month == 1) {
                    i += 1;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 2) {
                    i += 2;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                }

                else if (month == 3) {
                    i += 3;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 4) {
                    i += 4;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 5) {
                    i += 5;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 6) {
                    i += 6;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 7) {
                    i += 7;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 8) {
                    i += 8;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 9) {
                    i += 9;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 10) {
                    i += 10;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 11) {
                    i += 11;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    break;
                } else if (month == 12) {
                    i += 12;
                    salaryDiary[i] = (long) (indexSalary * baseSalary * 26 + overtime * overtimeSalary
                            - someHolidays * baseSalary);
                    // i++;
                    break;
                }
            } else {
                i += 12;
            }
        }
        return (long) salaryDiary[i];
    }

    @Override
    public void outputSalary() {
        int yearCount = 1;
        int i = 0;
        // while (true) {
        // if (salaryDiary[i] == 0) {
        // break;
        // } else {
        // // i++;
        // for (int j = 1; j <= 12; j++) {
        // i++;
        // System.out.println("Salary month " + j + " > ");
        // System.out.println(salaryDiary[i]);
        // }
        // i++;
        // yearCount++;
        // }
        // if (yearCount == 10)
        // break;
        // }
        for (Account o : MenuHandle.listAccount) {
            System.out.println(o.getEmployee().getSalaryDiary()[i]);
        }
    }

    @Override
    public String toString() {
        return "Chief Of Department" + "-" + getIdEmp() + "-" + getPosition() + "-" + getName() + "-" + getAge() + "-"
                + getGender() + "-" + getEmail() + "-" + getAddress() + "-" + getPhone();
    }

    @Override
    public String toStringSalary() {
        String str = "";
        int yearCount = 0;
        int i = 0;
        while (true) {
            // i++;
            // if (salaryDiary[i] == 0) {
            // break;
            // } else {
            str += "-" + String.valueOf(salaryDiary[i]);
            for (int j = 1; j <= 12; j++) {
                i += 1;
                str += "-" + String.valueOf(salaryDiary[i]);
            }
            i += 1;
            yearCount++;
            // }
            if (yearCount == 10)
                break;
        }
        return getIdEmp() + str;
    }
}
