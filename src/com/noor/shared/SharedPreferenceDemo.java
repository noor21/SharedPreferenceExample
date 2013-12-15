package com.noor.shared;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferenceDemo extends Activity {
	
	public static final String FILENAME="ShareDATA";
	public static final String KEYNAME="key";
	
	Button save,load;
	EditText edittext;
	private SharedPreferences sharedPreferences;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edittext=(EditText)findViewById(R.id.EditText01);
        save=(Button)findViewById(R.id.Button01);
        load=(Button)findViewById(R.id.Button02);
        
    
        save.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				sharedPreferences=getSharedPreferences(FILENAME, MODE_APPEND);
				Editor editor=sharedPreferences.edit();
				editor.putString(KEYNAME, edittext.getText().toString());
				editor.commit();
				edittext.setText("");
				
			}
		});
        
        
        load.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sharedPreferences=getSharedPreferences(FILENAME, MODE_PRIVATE);
				edittext.setText(sharedPreferences.getString(KEYNAME, "No Value Inserted"));
				
				
			}
		});
        
    
    }
}