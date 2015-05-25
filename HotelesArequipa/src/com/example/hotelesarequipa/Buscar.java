package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends ActionBarActivity {
	
	//String hoteles[]= getResources().getStringArray(R.array.hoteles);
		String hoteles[]={"Tierra Viva","Casa Andina","Lago Estelar","Libertador","The Mint","Sonesta Posada del Inca","hotel6","hotel7"};
		Button buscar;
		String palabra;
		TextView a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
		
		//buscar = (Button) findViewById(R.id.button1);
		
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,hoteles);
				
				AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
				
				textView.setThreshold(3);
				textView.setAdapter(adapter);
				a=textView;
			}
			
			public void Enlaza(View v) {
				// TODO Auto-generated method stub
				switch(a.getText().toString()){
				case "Tierra Viva":
						Intent sig0= new Intent(this,TierraViva.class);
						startActivity(sig0);
						break;
				case "Casa Andina":
						Intent sig1= new Intent(this,CasaAndina.class);
						startActivity(sig1);
						break;
				case "Lago Estelar":
					Intent sig2= new Intent(this,LagoEstelar.class);
					startActivity(sig2);
					break;
				case "Libertador":
					Intent sig3= new Intent(this,Libertador.class);
					startActivity(sig3);
					break;
				case "The Mint":
					Intent sig4= new Intent(this,Mint.class);
					startActivity(sig4);
					break;
				case "Sonesta Posada del Inca":
					Intent sig5= new Intent(this,SonestaPosadaDelInca.class);
					startActivity(sig5);
					break;
				case "hotel6":
					Intent sig6= new Intent(this,MainActivity.class);
					startActivity(sig6);
					break;
				case "hotel7":
					Intent sig7= new Intent(this,MainActivity.class);
					startActivity(sig7);
					break;
				default:
					Toast.makeText(Buscar.this,a.getText().toString(),Toast.LENGTH_LONG).show();
					}
				}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buscar, menu);
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
