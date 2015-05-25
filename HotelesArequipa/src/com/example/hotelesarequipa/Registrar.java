package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends ActionBarActivity {
	
	EditText user,email,pass;
	Button in,out;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registrar);
	}
	
	public void registrar(View v)
	{	
		user=(EditText) findViewById(R.id.User);
		email=(EditText) findViewById(R.id.EditText01);
		pass=(EditText) findViewById(R.id.Password);
		
		Handler_sqlite helper = new Handler_sqlite(this);
        helper.abrir();
        helper.insertarReg(user.getText().toString(),email.getText().toString(),
        		pass.getText().toString());
        helper.cerrar();
        
        user.setText("");
		email.setText("");
		pass.setText("");
        
		Toast.makeText(Registrar.this,"registrado satisfactoriamente",
				Toast.LENGTH_LONG).show();
		Intent act= new Intent(this,Sesion.class);
		startActivity(act);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registrar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
