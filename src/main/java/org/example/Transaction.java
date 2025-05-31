package org.example;
import java.util.*;
public class Transaction
{
    String type;
    int acNo;
    int amount;
    int balancce;
    public Transaction(int acNo,String type,int amount,int balance)
    {
        this.acNo=acNo;
        this.type=type;
        this.amount=amount;
        this.balancce=balance;
    }
}
