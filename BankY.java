import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class Account
{
   private String accountNumber;
   private String holderName;
   private double balance;

   public Account(String accountNumber,String holderName,double balance)
   {
    this.accountNumber=accountNumber;
    this.holderName=holderName;
    this.balance=balance;
   }
   public void deposite(double amount)
   {
    balance += amount;
   }
   public boolean withdraw(double amount)
   {
    if(amount <= balance)
    {
        balance -= amount;
        return true;
    }
    return false;
   }
   public double getBalance()
   {
    return balance;
   }
   public String getAccountNumber()
   {
    return accountNumber;
   }
   public String getHolderName()
   {
    return holderName;
   }

}
class Bank
{
    private Map<String, Account> accounts = new HashMap<>();
    public void createAccount(String accountNumber,String holderName,double initialDeposite)
    {
    if(accounts.containsKey(accountNumber))
    {
        System.out.println("Account alreay exits ");
        return;
    }
    Account account = new Account(accountNumber,holderName,initialDeposite);
    accounts.put(accountNumber,account);
    System.out.println("Account created successfully ");
    }
    public Account getAccount(String accountNumber)
    {
        return accounts.get(accountNumber);
    }
    public boolean transfer (String fromAcc,String toAcc,double amount)
    {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);
        if(from != null && to != null && from.withdraw(amount))
        {
            to.deposite(amount);
            return true;
        }
        return false;
    }
    
}
public class BankY
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice;
        do
        {
        System.out.println("----BANKY MENU----");
        System.out.println("1)Create account");
        System.out.println("2)Deposite");
        System.out.println("3)Withdraw");
        System.out.println("4)Transper");
        System.out.println("5)Check balance");
        System.out.println("6)Exit");

        System.out.print("Enter your choice : ");
        choice = sc.nextInt();
        switch(choice)
        {
            case 1:
            System.out.print("Account number : ");
            String accNo = sc.next();
            System.out.print("Account holder name : ");
            String name = sc.next();
            System.out.print("Initial deposite : ");
            double deposite = sc.nextDouble();
            bank.createAccount(accNo,name,deposite);
            break;

            case 2:
            System.out.print("Account number : ");
            accNo = sc.next();
            System.out.print("Amount : ");
            deposite = sc.nextDouble();
            Account acc1 = bank.getAccount(accNo);
            if(acc1 != null)
            {
                acc1.deposite(deposite);
                System.out.println("Deposited successfully");
            }
            else
            {
                System.out.println("Account not found");
                System.out.println("Try again");

            }
            break;

            case 3:
            System.out.print("Account number : ");
            accNo = sc.next();
            System.out.print("Amount : ");
            double withdraw = sc.nextDouble();
            Account acc2 = bank.getAccount(accNo);
            if(acc2 != null && acc2.withdraw(withdraw))
            {
                System.out.println("Withdraw successfull");
            }
            else
            {
                System.out.println("Insufficient balance or account not found ");
            }
            break;

            case 4:
            System.out.print("From account : ");
            String from = sc.next();
            System.out.print("To account : ");
            String to = sc.next();
            System.out.print("Amount : ");
            double amt = sc.nextDouble();
            if(bank.transfer(from,to,amt))
            {
                System.out.println("Transfer successful ");
            }
            else
            {
                System.out.println("Transfer failed ");
            }
            break;


            case 5:
            System.out.print("Account number : ");
            accNo = sc.next();
            Account acc3 = bank.getAccount(accNo);
            if(acc3 != null)
            {
                System.out.println("Balance : "+ acc3.getBalance());
            }
            else
            {
                System.out.println("Account not found ");
            }
            break;

            case 6:
            System.out.println("Thank you for using BankY");
            break;

            default:
            System.out.println("Invalid choice");
        }
    }
    while(choice != 6);
    sc.close();

    }
}