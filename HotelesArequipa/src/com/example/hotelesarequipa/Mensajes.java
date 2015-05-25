package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mensajes extends ActionBarActivity {
	
	EditText num,men;
	Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mensajes);
		
		num = (EditText) findViewById(R.id.editText2);
		men = (EditText) findViewById(R.id.editText1);
		send = (Button) findViewById(R.id.button1);
		
		send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendSms();
			}
		});
	}
	
	//mensajes
	
	
	
	private void sendSms()
		{
			String numero=num.getText().toString();
			String texto=men.getText().toString();
			
			SmsManager sms= SmsManager.getDefault();
			sms.sendTextMessage(numero,null,texto,null,null);
			
			Toast.makeText(getApplicationContext(),"mensaje enviado",
					Toast.LENGTH_LONG).show();
		}
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mensajes, menu);
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
