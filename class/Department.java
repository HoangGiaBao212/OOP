import java.util.Scanner;

//Thuộc tính: Mã phòng ban,tên phòng ban,tên trưởng phòng,số lượng nhân viên,
public class Department {
    private static Scanner scanner = new Scanner(System.in);
    private String departmentId;
    private String departmentName;
    private String idChief;
    private int members;
    private String[] idEmployee;

    public Department() {

    }

    public Department(String departmentId, String departmentName, String idChief, int members, String[] idEmployee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.idChief = idChief;
        this.members = members;
        this.idEmployee = idEmployee;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        departmentId = Handle.inputId("D");
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        System.out.print("Enter the Department's name: ");
        departmentName = scanner.nextLine();
        while (departmentName.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            departmentName = scanner.nextLine();
        }
        this.departmentName = departmentName;
    }

    public int getMembers() {
        return this.members;
    }

    public void setMembers(int members) {
        if (members < 0) {
            System.out.print("Enter the amount of members: ");
            members = Handle.getInputNumber();
            while (members < 0 && members >= 5) {
                System.out.print("Members must greater than 0 and less or equal to 5.Please enter again: ");
                members = Handle.getInputNumber();
            }
        }
        this.members = members;
    }

    public String getIdChief() {
        return idChief;
    }

    public void setIdChief(String idChief) {
        System.out.print("Input id chief :");
        idChief = Handle.inputId(idChief);
        this.idChief = idChief;
    }

    public String[] getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String[] idEmployee) {
        idEmployee = new String[members];
        System.out.println(" ------ Enter id for employee ----------- ");
        for (int i = 0; i < members; i++) {
            System.out.print(" ==> Enter id of employee number: " + i);
            idEmployee[i] = new String();
            idEmployee[i] = Handle.inputId("E");
        }
        this.idEmployee = idEmployee;
    }

    public void input() {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
        setMembers(members);
        setIdEmployee(idEmployee);
    }

    public void output() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("\n     %-15s|     %-15s|     %-15s     %-15s", departmentId, departmentName, idChief,
                idChief);
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < members; i++) {
            System.out.println("\n" + idEmployee[i]);
        }
        System.out.println("\n-------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return departmentId + "-" + departmentName + "-" + members + "-" + idChief + "-" + toStringArray();
    }

    public String toStringArray() {
        String str = "";
        for (int i = 0; i < members; i++) {
            str += "-" + idEmployee[i];
        }
        return str;
    }
}
