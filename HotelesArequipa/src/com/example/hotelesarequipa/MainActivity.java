package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
	}
	
	public void hoteles(View v) {
		// TODO Auto-generated method stub
		
		Intent hoteles= new Intent(this,Hoteles.class);
		startActivity(hoteles);
	}
	
	public void buscar(View v) {
		// TODO Auto-generated method stub
		
		Intent buscar= new Intent(this,Buscar.class);
		startActivity(buscar);
	}
	
	public void Inicio(View v) {
		// TODO Auto-generated method stub
		
		Intent inicio= new Intent(this,Sesion.class);
		startActivity(inicio);
	}
	public void fin(View v) {
		// TODO Auto-generated method stub
		
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()){
		case R.id.Ayuda:
			Toast.makeText(MainActivity.this,"ayuda login: inicia sesion o registrate. buscar: busca un hotel. hoteles: mira los hoteles. salir: salir del programa.",Toast.LENGTH_LONG).show();
			return true;
		case R.id.Acercade:
			Toast.makeText(MainActivity.this,"Aplicacion para busqueda de hoteles en la ciudad de Arequipa. Creador Copara",Toast.LENGTH_LONG).show();
			return true;
		case R.id.action_settings:
			Intent inicio= new Intent(this,Ajustes.class);
			startActivity(inicio);
			return true;
		case R.id.Salir:
			Toast.makeText(MainActivity.this,"Salir",Toast.LENGTH_LONG).show();
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
		
	}
}
