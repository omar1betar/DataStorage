package com.betaromar.omar1betar.datastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.widget.Toast.LENGTH_SHORT;

public class FileIO extends AppCompatActivity {

    EditText data;
    Button writeButton;
    TextView readFfromFile;
    final String FILE_NAME = "tempFile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);
        data =(EditText)findViewById(R.id.data_edit_text);
        writeButton = (Button)findViewById(R.id.write_button);
        readFfromFile = (TextView)findViewById(R.id.text_view);


        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(FILE_NAME,MODE_APPEND);
                    fos.write(data.getText().toString().getBytes());
                    fos.close();
                    Toast.makeText(FileIO.this,"done write successfully",Toast.LENGTH_LONG).show();
                    readFromFile();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        readFromFile();
    }

    private void readFromFile(){
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            readFfromFile.setText(new String(buffer));
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}