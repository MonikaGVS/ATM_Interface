import java.util.Scanner;

import javax.swing.JOptionPane;

class BankAccount {
    int balance;
    int prevTransaction;
    String userName;
    String userId;
    int flag = 0;

    BankAccount(String uName, String uId) {
        userName = uName;
        userId = uId;
    }

    public final void clrscr() {
        try {
            try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } catch (final Exception es) {
        // System.out.println("nothing here!");
    }

    }

    void checkId() {
        clrscr();
        JOptionPane.showMessageDialog(null, "***Welcome to ATM*** \n To access the ATM functionings \n please click on 'OK' button","ATM Machine",3);
        System.out.println("Welcome " + userName);
        System.out.println();
        //System.out.print("Please enter the Customer ID or PIN: ");
        JOptionPane.showInputDialog(null, "Please enter the User PIN :","user logging",3);
        System.out.print("Please enter the PIN again for confirmation: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(userId)) {
            clrscr();
            showMenu();
        } else {
            //System.out.println("=================================");
            System.out.println(" ------------------------------");
            System.out.println("|  Wrong Login!!check again    |");
            System.out.println(" ------------------------------");
            //System.out.println("=================================");

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            //System.out.println("=================================");
            System.out.println(" ---------------------------------------------------------------");
            System.out.println("|                Insufficient Balance to withdraw               |");
            System.out.println(" ---------------------------------------------------------------");
            //System.out.println("=================================");
        }
    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occured ");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();
            //System.out.println("=================================");
            System.out.println(" ---------------------------------------------------------------");
            System.out.println("|       Transfer unsuccessful due to insufficient balance!      |");
            System.out.println(" ---------------------------------------------------------------");
            //System.out.println("=================================");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.userName + " becomes $" + this.balance);
            //System.out.println("Account of " + acc.customerName + " becomes $" + acc.balance);
            System.out.println("Account of receiver becomes $" + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + userName);
        System.out.println("Your ID is  " + userId);
        JOptionPane.showMessageDialog(null, "Logged In Successfully \n click 'OK' for further steps","user page",3);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("A. Transaction History");
            System.out.println("B. Withdraw");
            System.out.println("C. Deposit");
            System.out.println("D. Transfer");
            System.out.println("E. Check Balance");
            System.out.println("F. Exit");

            //System.out.println("=================================");
            System.out.println(" ---------------------------------------------------------------");
            System.out.println("|          please Enter the option in the given Menu            |");
            System.out.println(" ---------------------------------------------------------------");
            //System.out.println("=================================");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    clrscr();
                    System.out.println("================");
                    getPrevTransaction();
                    System.out.println("================");
                    System.out.println("\n");
                    JOptionPane.showMessageDialog(null, "Click 'OK' for next function","steps",3);
                    break;

                case 'B':
                    clrscr();
                    //System.out.println("================");
                    System.out.println(" ---------------------------------------------------------");
                    System.out.println("|                 Enter the amount to withdraw            |");
                    System.out.println(" ---------------------------------------------------------");
                    //System.out.println("================");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    JOptionPane.showMessageDialog(null, "Click 'OK' for next function","steps",3);
                    break;
                
                case 'C':
                    clrscr();
                    //System.out.println("================");
                    System.out.println(" ------------------------------------------------------");
                    System.out.println("|            Enter the amount to deposit                |");
                    System.out.println(" ------------------------------------------------------");
                    //System.out.println("================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    JOptionPane.showMessageDialog(null, "Click 'OK' for next function","steps",3);
                    break;

                case 'D':
                    clrscr();
                    System.out.println("*****");
                    System.out.println("To whom");
                    Scanner in= new Scanner(System.in); //System.in is a standard input stream.
                    System.out.print("Enter the receiver name : ");
                    final String uName= in.nextLine();
                    //System.out.println("Enter the receiver name:");
                    
                    BankAccount bb = new BankAccount(" ", " ");
                    System.out.println(bb.userName);
                    //System.out.println("*****");
                    System.out.println(" ------------------------------------------------------");
                    System.out.println("|             Enter Amount to Transfer                  |");
                    System.out.println(" ------------------------------------------------------");
                    double am = sc.nextDouble();
                    //System.out.println(" ------------------------------------------------------");
                    //System.out.println("*****");
                    transfer(am, bb);
                    JOptionPane.showMessageDialog(null, "Click 'OK' for next function","steps",3);
                    break;

                case 'E':
                    clrscr();
                    //System.out.println("================");
                    System.out.println(" ------------------------------------------------");
                    System.out.println("|       Your Balance amount is : " + balance +"               |");
                    System.out.println(" ------------------------------------------------");
                    //System.out.println("================");
                    System.out.println("\n");
                    JOptionPane.showMessageDialog(null, "Click 'OK' for next function","steps",3);
                    break;

                case 'F':
                    clrscr();
                    System.out.println("*****");
                    JOptionPane.showMessageDialog(null, "Click 'OK' for next function","steps",3);
                    break;
                
                default:
                    clrscr();
                    System.out.println("Invalid Option!!! Please Enter Again");
            }

        } while (option != 'F');
        System.out.println("ThankYou For using our services");
        JOptionPane.showMessageDialog(null, "Thank You!! \n Visit again \n use these services Happily","steps",3);

    }
}

public class ATM {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Monika", "1234");
        ba.checkId();
    }

}