package com.example.vfinancesproject;

import java.util.ArrayList;

public class Note
{
    public static ArrayList<Note> noteArrayList = new ArrayList<>();
    public static String NOTE_EDIT_EXTRA = "noteEdit";
    private int id;
    private String tag;
    private int price;
    private String category;

    public Note(int id, String tag, int price, String category)
    {
        this.tag = tag;
        this.price = price;
        this.category = category;
        this.id = id;
    }

    public static Note getNoteForID(int passedNoteID) {
        for(Note note : noteArrayList)
        {
            if(note.getId() == passedNoteID)
                return note;
        }
        return null;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public int getPrice()
    {
        return this.price;
    }

    public void setPrice(int pr)
    {
        price = pr;
    }

    public String getTag()
    {
        return this.tag;
    }

    public void setTag(String ta)
    {
        this.tag = ta;
    }

    public String getCategory()
    {
        return this.category;
    }
    public void setCategory(String cat)
    {
        this.category= cat;
    }

}