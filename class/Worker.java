public abstract class Worker extends Person {
    private Long salaryDiary[];

    public Worker() {

    }

    public Worker(Long[] salaryDiary) {
        this.salaryDiary = salaryDiary;
    }

    public Worker(String name, int age, String gender, String email, String address, String phone,
            Long[] salaryDiary) {
        super(name, age, gender, email, address, phone);
        this.salaryDiary = salaryDiary;
    }

    public Long[] getSalaryDiary() {
        return salaryDiary;
    }

    public void setSalaryDiary(Long[] salaryDiary) {
        this.salaryDiary = salaryDiary;
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void output() {

    }

    public abstract double netSalary(String idEmp);

}
