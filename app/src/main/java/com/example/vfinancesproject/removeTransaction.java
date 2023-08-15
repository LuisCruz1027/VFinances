package com.example.vfinancesproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class removeTransaction extends AppCompatActivity {

    private ListView noteListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_transaction);
        initWidgets();
        setNoteAdapter();
        loadFromDBToMemory();
        setOnClickListener();


      /*  int id1 = 2;
        String tag1 = "HEB";
        int price1 = 123;
        String category1 = "Food";
        DBHelperTransactions dbHelperTransactions = new DBHelperTransactions(this);
        Note note = new Note(id1,tag1, price1, category1);
        boolean result = dbHelperTransactions.insertData(note);
*/

    }




    private void initWidgets()
    {
        noteListView= findViewById(R.id.listview);
    }
    private void loadFromDBToMemory()
    {
        DBHelperTransactions dbHelperTransactions = DBHelperTransactions.instanceOfDatabase(this);
        dbHelperTransactions.populateNoteListArray();
    }

    private void setNoteAdapter()
    {
        NoteAdapter noteAdapter = new NoteAdapter(getApplicationContext(),Note.noteArrayList);
        noteListView.setAdapter(noteAdapter);
    }
    private void setOnClickListener()
    {
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Note selectedNote = (Note) noteListView.getItemAtPosition(position);
                Intent editNoteIntent = new Intent(getApplicationContext(), confirmationDeletion.class);
                editNoteIntent.putExtra(Note.NOTE_EDIT_EXTRA, selectedNote.getTag());
                startActivity(editNoteIntent);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setNoteAdapter();
    }

}