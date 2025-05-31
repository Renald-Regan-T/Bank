package org.example;
import java.util.*;
public class Customer
{
    int id;
    int acNo;
    String name;
    int balance;
    String encryptedPwd;
    List<Transaction>transactions;

    public Customer(int id,int acNo,String name,int balance,String encryptedPwd)
    {
        this.id=id;
        this.acNo=acNo;
        this.name=name;
        this.balance=balance;
        this.encryptedPwd=encryptedPwd;
        this.transactions=new ArrayList<>();
    }
}
