package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView.OnCloseListener;

public class Hoteles extends ActionBarActivity {
	
	ImageView h0,h1,h2,h3,h4,h5,h6,h7,h8,h9;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hoteles);
		
		
	}
	
	public void Enlaza0(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,TierraViva.class);
		startActivity(sig);
	}
	
	public void Enlaza1(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,CasaAndina.class);
		startActivity(sig);
	}
	public void Enlaza2(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,LagoEstelar.class);
		startActivity(sig);
	}
	public void Enlaza3(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,Libertador.class);
		startActivity(sig);
	}
	public void Enlaza4(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,Mint.class);
		startActivity(sig);
	}
	
	public void Enlaza5(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,SonestaPosadaDelInca.class);
		startActivity(sig);
	}
	
	public void Enlaza6(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,TierraViva.class);
		startActivity(sig);
	}
	
	public void Enlaza7(View v) {
		// TODO Auto-generated method stub
			
		Intent sig= new Intent(this,TierraViva.class);
		startActivity(sig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hoteles, menu);
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
