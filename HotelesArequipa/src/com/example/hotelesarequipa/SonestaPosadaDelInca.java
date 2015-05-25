package com.example.hotelesarequipa;

import com.example.hotelesarequipa.CasaAndina.ImageAdapter;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class SonestaPosadaDelInca extends ActionBarActivity {
	
	float num=0,rat=0,flag=0;
	//TextView ratingTxt;
	Button ver,res,donde,llamada,puntuar;
	ImageView portada,fondo;
	RatingBar estrella;
	Integer[] imagenId={
			R.drawable.ima51,
			R.drawable.ima52,
			R.drawable.ima53,
			R.drawable.ima54,
			R.drawable.ima55,
			R.drawable.ima56
			
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sonesta_posada_del_inca);
		
		Gallery galeria = (Gallery) findViewById(R.id.gallery1);
		galeria.setAdapter(new ImageAdapter(this));
				
		//estado de botones
		
		ver=(Button) findViewById(R.id.Pagina);
		res=(Button) findViewById(R.id.Reservar);
		donde=(Button) findViewById(R.id.Ubicacion);
		llamada = (Button)findViewById(R.id.llamar);
		puntuar = (Button)findViewById(R.id.puntuar);
		
		//estado de rating
		estrella=(RatingBar) findViewById(R.id.ratingBar1);
		puntuar.setEnabled(false);
		
		
		
		//verificiar si se clickea para rating y el boton de votar
		
		estrella.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub
				puntuar.setEnabled(true);
				puntuar.setText("Vota");
								
			}} );
		
		puntuar.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			num=num+1;
			rat=rat+estrella.getRating();
			Toast.makeText(SonestaPosadaDelInca.this,String.valueOf(estrella.getRating()),Toast.LENGTH_SHORT).show();
			estrella.setRating(rat/num);
			puntuar.setText(String.valueOf(estrella.getRating()));
			puntuar.setEnabled(false);
	     }
	     });
		
		//verificiar si se clickea para llamar
	 
	    llamada.setOnClickListener(new View.OnClickListener() {
	 
	     @Override
	     public void onClick(View v) {
	         // TODO Auto-generated method stub
	    	 /*try {
	 	        Intent callIntent = new Intent(Intent.ACTION_CALL);
	 	        callIntent.setData(Uri.parse("tel:123456789"));
	 	        startActivity(callIntent);
	 	    } catch (ActivityNotFoundException activityException) {
	 	        Log.e("dialing-example", "Call failed", activityException);
	 	    }*/
	    	 Uri tel =Uri.parse("tel:989717957");
	    	 Intent callIntent = new Intent(Intent.ACTION_CALL,tel);
	    	 startActivity(callIntent);
	     }
	     });
	    
	  //verificiar si se clickea para ver la pagina web
	    
	     ver.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri pag=Uri.parse("http://tierravivahoteles.com/es/tierra-viva-arequipa-plaza/");
				Intent viewIntent = new Intent(Intent.ACTION_VIEW,pag);
				startActivity(viewIntent);
				
				/*Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.google.com"));
				startActivity(intent);*/
				//android.content.Intent.ACTION_VIEW.
			}
		});
	     
	   //verificiar si se clickea para reservar una habitacion
	     
		res.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri reserva=Uri.parse("http://tierravivahoteles.com/es/reservas/");
				Intent viewIntent = new Intent(Intent.ACTION_VIEW,reserva);
				startActivity(viewIntent);
				
				/*Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.google.com"));
				startActivity(intent);*/
				//android.content.Intent.ACTION_VIEW.
			}
		});
		
		//verificiar si se clickea para ver en el mapa
		
		donde.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri ubica=Uri.parse("https://www.google.com.pe/maps/place/Tierra+Viva+Arequipa+Plaza/@-16.397598,-71.534504,15z/data=!4m2!3m1!1s0x0000000000000000:0x29f7bb25311e3c08");
				Intent viewIntent = new Intent(Intent.ACTION_VIEW,ubica);
				startActivity(viewIntent);
				
				/*Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.google.com"));
				startActivity(intent);*/
				//android.content.Intent.ACTION_VIEW.
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sonesta_posada_del_inca, menu);
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
	
	public void Mensaje(View v) {
		// TODO Auto-generated method stub
		
		Intent mensaje= new Intent(this,Mensajes.class);
		startActivity(mensaje);
	}
	
	public void Emails(View v) {
		// TODO Auto-generated method stub
		
		Intent email= new Intent(this,Email.class);
		startActivity(email);
	}
	
	//clase para la galeria
			public class ImageAdapter extends BaseAdapter{

				private Context contexto;
				public ImageAdapter(SonestaPosadaDelInca sonestaPosadaDelInca) {
					// TODO Auto-generated constructor stub
					contexto=sonestaPosadaDelInca;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return imagenId.length;
				}

				@Override
				public Object getItem(int position) {
					// TODO Auto-generated method stub
					return position;
				}

				@Override
				public long getItemId(int position) {
					// TODO Auto-generated method stub
					return position;
				}

				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					ImageView imagen = new ImageView(contexto);
					imagen.setImageResource(imagenId[position]);
					imagen.setLayoutParams(new Gallery.LayoutParams(160,130));
					
					return imagen;
				}
			};
}
