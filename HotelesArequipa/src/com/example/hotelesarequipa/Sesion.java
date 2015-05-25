package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sesion extends ActionBarActivity {
	
	EditText user,pass;
	CheckBox guarda;
	Button in,out;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio_sesion);
		
		Handler_sqlite helper = new Handler_sqlite(this);
        helper.abrir();
        //final String x[] = helper.leerUser();
        //final String y[] = helper.leerPass();
        final String x[] ={"aleco"};
        final String y[] ={"12345"};
        helper.cerrar();
		
		user = (EditText) findViewById(R.id.User);
		pass = (EditText) findViewById(R.id.Password);
		guarda = (CheckBox) findViewById(R.id.Guardar);
		in = (Button) findViewById(R.id.Entrar);
		out = (Button) findViewById(R.id.Registrar);
		cargarpreferencias();
		
		out.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user.setText("");
				pass.setText("");
				Toast.makeText(Sesion.this,"registrar",Toast.LENGTH_LONG).show();
				registrar();
			}
		});
		
		
		
		
		
		in.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(int i=0;i<x.length;i++){
					if(user.getText().toString().equals(x[i]) && 
							pass.getText().toString().equals(y[i]) ){
						Toast.makeText(Sesion.this,"ingreso",Toast.LENGTH_LONG).show();
						if(guarda.isChecked()){	guardarpreferencias();}
						pasar();
						break;
					}
					else{Toast.makeText(Sesion.this,"no ingreso",Toast.LENGTH_LONG).show();}
				}
				
			}
			});
		
		
	}
	
	public void cargarpreferencias() {
		// TODO Auto-generated method stub
		
		SharedPreferences preferencia=getSharedPreferences
				("preferenciasUsuario",Context.MODE_PRIVATE);
		guarda.setChecked(preferencia.getBoolean("checked",false));
		user.setText(preferencia.getString("usuario",""));
	}
	
	public void guardarpreferencias() {
		// TODO Auto-generated method stub
		
		SharedPreferences preferencia=getSharedPreferences
				("preferenciasUsuario",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencia.edit();
		boolean valor=guarda.isChecked();
		String nombre=user.getText().toString();
		editor.putBoolean("checked",valor);
		editor.putString("usuario",nombre);
		editor.commit();
	}
	
	public void pasar() {
		// TODO Auto-generated method stub
		
		user.setText("");
		pass.setText("");
		Intent home= new Intent(this,MainActivity.class);
		startActivity(home);
	}
	
	public void registrar() {
		// TODO Auto-generated method stub
		Intent home= new Intent(this,Registrar.class);
		startActivity(home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sesion, menu);
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
