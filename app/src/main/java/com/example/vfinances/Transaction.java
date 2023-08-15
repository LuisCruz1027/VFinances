package com.example.vfinances;

public class Transaction
{
    private int id;
    private String type; // "expense" or "income"
    private double amount;
    private String tag;

    public Transaction(int id, String type, double amount, String tag)
    {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.tag = tag;
    }

    public int getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }

    public double getAmount()
    {
        return amount;
    }

   public String getTag()
   {
       return tag;
   }
}
