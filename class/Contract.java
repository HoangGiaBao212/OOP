import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Contract implements InOut {
    Scanner sc = new Scanner(System.in);

    private String contractID;
    // private String timeStart;
    // private String timeEnd;
    private Date timeStart;
    private Date timeEnd;
    public Contract() {
    }

    public Contract(String contractID, Date timeStart, Date timeEnd) {
        this.contractID = contractID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getContractID() {
        return this.contractID;
    }

    public void setContractID(String contractID) {
        System.out.print("Enter the contrac ID: ");
        contractID = sc.nextLine();
        while (contractID.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            contractID = sc.nextLine();
        }
        if (!contractID.startsWith("C")) {
            System.out.print("Contrac ID must start with letters C (Ex:C001).Please enter again:");
            contractID = sc.nextLine();
        }
        this.contractID = contractID;
    }

    public Date getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(Date timeStart){
        this.timeStart = timeStart;
    }
    public Date getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(Date timeEnd){
        this.timeEnd = timeEnd;
    }
    @Override
    public void input() {
        setContractID(contractID);
        System.out.print("Enter time Start: ");
        setTimeStart(MenuHandle.getInputDate());
        do{
            System.out.print("Enter time End: ");
            setTimeEnd(MenuHandle.getInputDate());
            if(timeEnd.after(timeStart) == false){
                System.out.println("Time End incorrect");
            }

        }while(timeEnd.after(timeStart) == false);
    }

    @Override
    public void output() {
        System.out.printf("|   %-15s|", contractID);
        // super.output();
        System.out.printf("    %-15s|   %-15s", new SimpleDateFormat("dd/MM/yyyy").format(timeStart), new SimpleDateFormat("dd/MM/yyyy").format(timeEnd));
    }

    @Override
    public String toString() {
        return getContractID() + "-" + new SimpleDateFormat("dd/MM/yyyy").format(timeStart) + "-" + new SimpleDateFormat("dd/MM/yyyy").format(timeEnd);
    }

}
