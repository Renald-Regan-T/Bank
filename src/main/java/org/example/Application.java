package org.example;

import java.util.*;

public class Application
{
    Map<Integer,Customer>customers=new TreeMap<>();
    List<Transaction>global_Transactions=new ArrayList<>();
    String users_data="users.txt";
    String global_transaction="transaction.txt";
    File_handling fl=new File_handling();
    int idgenerater=0;

    public  void load_Customer()
    {
        add_Customer(this.idgenerater+=11,1001*this.idgenerater,"Kumar",10000,"ApipNbjm");
        add_Customer(this.idgenerater+=11,1001*this.idgenerater,"Madhu",20000,"Cboljoh");
        add_Customer(this.idgenerater+=11,1001*this.idgenerater,"Rahul",30000,"dbnqvt");
        add_Customer(this.idgenerater+=11,1001*this.idgenerater,"Robin",40000,"kbwb22");
    }

    public void add_Customer(String name,String pw)
    {
        add_Customer(this.idgenerater+=11,1001*this.idgenerater,name,10000,pw);
    }

    public void add_Customer(int id,int acNo,String name,int balance,String encrypted)
    {
        Customer cust=new Customer(id,acNo,name,balance,encrypted);
        customers.put(acNo,cust);
        Transaction trans=new Transaction(acNo,"Opening",balance,balance);
        cust.transactions.add(trans);
        global_Transactions.add(trans);
        this.fl.file_write2(customers,users_data);
        //System.out.println(cust.acNo);
        this.fl.file_write(global_transaction,cust.acNo+" "+"Opening "+balance+" "+balance);
        System.out.println(cust.acNo);

    }

    public String encry_Pw(String s)
    {
        StringBuilder pw = new StringBuilder(s.length());
        for(char c:s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
                pw.append((char) ((c=='z')?'a':(c=='Z')?'A':(c=='9')?0:c+1));
            else
                pw.append(c+1);
        }
        return pw.toString();
    }

    public void display()
    {
        System.out.println("CustId AccountNo Name Balance EncryptedPwd");
        for(int i:this.customers.keySet())
        {
            Customer cust = this.customers.get(i);
            System.out.println(cust.id+" "+cust.acNo+" "+cust.name+" "+cust.balance+" "+cust.encryptedPwd);
        }
    }

    public boolean authentication(int acNo,String pw)
    {
        Customer cust=this.customers.get(acNo);
        if(cust.encryptedPwd.equals(encry_Pw(pw)))
            return true;
        return false;
    }

    public void atm_withdrawal(int accNo,int amount)
    {
        Customer cust = this.customers.get(accNo);
        if (cust.balance >= amount) {
            cust.balance -= amount;
            Transaction trans = new Transaction(accNo,"Withdrawal", amount, cust.balance);
            cust.transactions.add(trans);
            global_Transactions.add(trans);
           // this.fl.file_write(users_data, cust.acNo + " " + cust.acNo + " " + cust.name + " " + cust.balance + " " + cust.encryptedPwd);
            this.fl.file_write(global_transaction, cust.acNo + " " + "Withdrawal " + amount + " " + cust.balance);
            System.out.println(cust.acNo + " " + cust.name + " " + cust.balance);
        }
        else
            System.out.println("Insufficent amount!");
    }
    public void atm_deposit(int acNo,int amount)
    {
        Customer cust=this.customers.get(acNo);
        cust.balance+=amount;
        cust.transactions.add(new Transaction(acNo,"Deposit",amount,cust.balance));
        //this.fl.file_write(users_data,cust.acNo+" "+cust.acNo+" "+cust.name+" "+cust.balance+" "+cust.encryptedPwd);
        this.fl.file_write(global_transaction,cust.acNo+" "+"Deposit "+amount+" "+cust.balance);
        System.out.println(cust.acNo+" "+cust.name+" "+cust.balance);
    }

    public void account_transfer(int from,int to,int amount)
    {
        Customer fcust=this.customers.get(from);
        Customer tcust=this.customers.get(to);
        if(fcust.balance>=amount)
        {
            tcust.balance += amount;
            fcust.balance -= amount;
            fcust.transactions.add(new Transaction(from,"Transferto"+fcust.acNo,amount,fcust.balance));
            tcust.transactions.add(new Transaction(to,"TransferFrom"+tcust.acNo,amount,tcust.balance));
          //  this.fl.file_write(users_data,fcust.acNo+" "+fcust.acNo+" "+fcust.name+" "+fcust.balance+" "+fcust.encryptedPwd);
            this.fl.file_write(global_transaction,fcust.acNo+" "+"Transferto "+amount+" "+fcust.balance);
            this.fl.file_write(global_transaction,tcust.acNo+" "+"Transferfrom "+amount+" "+tcust.balance);

        }
        else
            System.out.println("Insufficent balance");
    }

    public void transaction_history(int acNo)
    {
        Customer cust=this.customers.get(acNo);
        System.out.println("Account Statements:");
        System.out.println("Name: "+cust.name+"\nAccount No: "+cust.acNo+"\nCustomerId :"+cust.id);
        if(!cust.transactions.isEmpty()) {
            for (Transaction i : cust.transactions)
                System.out.println(i.type +" "+i.amount +" "+i.balancce);
        }
        else
            System.out.println("No history for thus cutomer "+acNo);
    }
    public void persistent_file()
    {
        for(Customer c:this.customers.values())
            this.fl.file_write(this.users_data,c.id+" "+c.acNo+" "+c.name+" "+c.balance+" "+c.encryptedPwd);
    }

    public void file_list()
    {
        this.customers.clear();
        this.global_Transactions.clear();

        List<String>customers=this.fl.file_read(users_data);
        for(String s:customers)
        {
            String[]str=s.split(" ");
//            for(String i:str)
//                System.out.print(i+" ");
            int acNo=Integer.parseInt(str[0]);
            Customer cust=new Customer(acNo,Integer.parseInt(str[1]),str[2],Integer.parseInt(str[3]),str[4]);
            this.customers.put(acNo,cust);
        }
        System.out.println();
        List<String>trans=this.fl.file_read(global_transaction);
        for(String s:trans)
        {
            String[]str=s.split(" ");
//            for(String i:str)
//                System.out.print(i+" ");
            int acNo=Integer.parseInt(str[0]);
            Transaction tran=new Transaction(acNo,str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]));
            System.out.println(acNo);
            Customer cust=this.customers.get(acNo);
            System.out.println(cust);
            cust.transactions.add(tran);
            if(cust!=null)
            {
                global_Transactions.add(tran);
                cust.transactions.add(tran);
            }
            else
                System.out.println("Warning!!");
        }
    }
}
