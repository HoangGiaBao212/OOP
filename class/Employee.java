import java.util.Scanner;

class Employee extends Worker implements InOut {

    static Scanner scanner = new Scanner(System.in);
    private String idEmp;
    private String position;
    private Contract contract;

    public Employee() {
        super();
    }

    public Employee(String idEmp, String position) {
        this.position = idEmp;
        this.position = position;
    }

    public Employee(String idEmp, String position, String name, int age, String gender, String email, String address,
            String phone) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
    }

    public Employee(String name, int age, String gender, String email, String address, String phone,
            String idEmp, String position, Contract contract) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
        this.contract = contract;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        idEmp = Handle.inputId(idEmp);
        this.idEmp = idEmp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return idEmp + "-" + position + "-" + super.toString();
    }

    @Override
    public void input() {
        super.input();
        // setIdEmp(idEmp);
    }

    @Override
    public void output() {
        System.out.printf("|  %-10s|  %-20s|", idEmp, position);
        super.output();
    }

    @Override
    public double netSalary(String idEmp) {
        // TODO Auto-generated method stub
        return 0;
    }
}