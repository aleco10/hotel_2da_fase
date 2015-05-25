package com.example.hotelesarequipa;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends ActionBarActivity {
	
	EditText con,men,asu;
	Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		con = (EditText) findViewById(R.id.editText2);
		men = (EditText) findViewById(R.id.editText1);
		asu = (EditText) findViewById(R.id.EditText01);
		send = (Button) findViewById(R.id.button1);
		
		send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Email();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}
	
	public void Email() {
		
		String para=con.getText().toString();
		String texto=men.getText().toString();
		String asunto = asu.getText().toString();
        sendEmail(para, null, asunto, texto);
    }
	
	private void sendEmail(String emailAddresses, String carbonCopies,
		    String subject, String message)
		    {
		        Intent emailIntent = new Intent(Intent.ACTION_SEND);
		        emailIntent.setData(Uri.parse("mailto:"));
		        String to = emailAddresses;
		        String cc = carbonCopies;
		        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
		        emailIntent.putExtra(Intent.EXTRA_CC, cc);
		        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
		        emailIntent.setType("message/rfc822");
		        startActivity(Intent.createChooser(emailIntent, "Email"));
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
