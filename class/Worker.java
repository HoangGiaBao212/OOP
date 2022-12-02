// import java.time.Year;

public abstract class Worker extends Person {
    protected double[] salaryDiary;

    public Worker() {

    }

    public Worker(String name, int age, String gender, String email, String address, String phone) {
        super(name, age, gender, email, address, phone);
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void output() {
        super.output();
    }

    public abstract Long netSalary(Float indexSalary, int someHolidays, int overtime, int year, int month);

    public abstract void outputSalary();

}
