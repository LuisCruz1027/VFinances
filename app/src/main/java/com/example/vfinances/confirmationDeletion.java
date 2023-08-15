package com.example.vfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vfinancesproject.DBHelperTransactions;

public class confirmationDeletion extends AppCompatActivity {

    private EditText tagEditText, priceEditText;
    private Button deleteButton;
    private Note selectedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_deletion);
        initWidgets();
        checkForEditNote();
    }

    private void initWidgets() {
        tagEditText = findViewById(R.id.tagEditText);
        priceEditText = findViewById(R.id.priceEditText);
        deleteButton = findViewById(R.id.deleteButton);

    }
    private void checkForEditNote()
    {
        Intent previousIntent = getIntent();

        int passedNoteID = previousIntent.getIntExtra(Note.NOTE_EDIT_EXTRA, -1);
        selectedNote = Note.getNoteForID(passedNoteID);

        if (selectedNote != null)
        {
            tagEditText.setText(selectedNote.getTag());
            priceEditText.setText(selectedNote.getPrice());
        }
        else
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }


    }
    public void deleteNote(View view)
    {

        DBHelperTransactions sqLiteManager = DBHelperTransactions.instanceOfDatabase(this);
        sqLiteManager.updateNoteInDB(selectedNote);
        finish();
    }
}