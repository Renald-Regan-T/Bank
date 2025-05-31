package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args)
    {
        Application app=new Application();
        //app.load_Customer();
        //app.file_list();

        int acNo,amount;
        String name,pw,re_pw;

        boolean loop=true;
        while (loop)
        {
            System.out.println("1.Add Customer\n2.ATM Withdrawal\n3.Cah Deposit\n4.Account Transfer\n5.Transaction history\n6.Exit");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:

                    System.out.println("Enter your name:");
                    name=sc.next();
                    System.out.println("Enter your password:");
                    pw=sc.next();
                    app.add_Customer(name,app.encry_Pw(pw));
                    break;

                case 2:

                    System.out.println("Welcome to Bank:\nEnter your AccontNo:");
                    acNo= sc.nextInt();
                    System.out.println("Enter your password:");
                    pw=sc.next();
                    System.out.println("Re-enter your pw:");
                    re_pw=sc.next();
                    if(pw.equals(re_pw))
                    {
                        if(app.authentication(acNo,pw))
                        {
                            System.out.println("Enter your amount");
                            amount= sc.nextInt();
                            app.atm_withdrawal(acNo,amount);
                        }
                        else
                            System.out.println("Invalid password!!!!!!");
                    }
                    else
                        System.out.println("Invalid Password!");
                    break;

                case 3:
                    System.out.println("Welcome to Bank:\nEnter your AccontNo:");
                    acNo= sc.nextInt();
                    System.out.println("Enter your password:");
                    pw=sc.next();
                    System.out.println("Re-enter your pw:");
                    re_pw=sc.next();
                    if(pw.equals(re_pw))
                    {
                        if(app.authentication(acNo,pw))
                        {
                            System.out.println("Enter your deposit amount");
                            amount= sc.nextInt();
                            app.atm_deposit(acNo,amount);
                        }
                        else {
                            //System.out.println(encry_Pw(pw));
                            System.out.println("Invalid Password!!!!!");
                            break;
                        }
                    }
                    else
                        System.out.println("Invalid Password!");
                    break;

                case 4:

                    System.out.println("Welloce to Bank\nEnter your from Account Number");
                    int from=sc.nextInt();
                    System.out.println("Enter a your password");
                    pw=sc.next();
                    System.out.println("Re-enter your password");
                    re_pw=sc.next();
                    if(app.authentication(from,pw))
                    {
                        System.out.println("Enter your to Account Number");
                        int to=sc.nextInt();
                        System.out.println("Enter your password");
                        pw= sc.next();
                        System.out.println("Re-enter your password");
                        re_pw= sc.next();
                        if(app.authentication(to,re_pw))
                        {
                            System.out.println("Enter your amount");
                            amount= sc.nextInt();
                            app.account_transfer(from,to,amount);
                        }
                        else
                            System.out.println("To user invalid password");
                    }
                    else
                        System.out.println("From user invalid password");
                    break;

                case 5:

                    System.out.println("Welcome to Bank\nEnter your Account Number");
                    acNo= sc.nextInt();
                    System.out.println("Enter your password");
                    pw=sc.next();
                    System.out.println("Re-enter your password");
                    re_pw=sc.next();
                    if(re_pw.equals(pw))
                    {
                        if(app.authentication(acNo,pw))
                            app.transaction_history(acNo);
                        else
                            System.out.println("Invalid password!!!!!");
                    }
                    else
                        System.out.println("Invalid user or password");
                    break;

                case 6:
                    app.persistent_file();
                    break;
                case 7:
                    app.file_list();
                    //app.display();
                    loop=false;
                    break;
                case 8:
                    app.display();
                    break;
            }
        }
        app.display();
    }
}