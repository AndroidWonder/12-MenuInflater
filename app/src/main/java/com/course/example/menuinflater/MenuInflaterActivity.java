package com.course.example.menuinflater;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;

public class MenuInflaterActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		//hide title and icon in action bar; 4/24/18
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);

    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Uri uri;
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.web:
	        	uri = Uri.parse("http://www.bentley.edu");
	        	startActivity(new Intent(Intent.ACTION_VIEW, uri));
	            return true;
	            
	        case R.id.maps:
	        	uri = Uri.parse("geo:0,0?q=175 Forest Street waltham ma");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);

				if (intent.resolveActivity(getPackageManager()) != null) {
					startActivity(intent);}
	            return true;   
	            
	        case R.id.dialer:
	        	uri = Uri.parse("tel:7818912000");
	        	startActivity(new Intent(Intent.ACTION_VIEW, uri));
	            return true;    
	            
	        case R.id.email:
	        	uri = Uri.parse("mailto:hbentley@bentley.edu");
	        	startActivity(new Intent(Intent.ACTION_SENDTO, uri));
	            return true;    
	            
	        case R.id.save:
	        	            //dud 
	            return true;    
	            
	        case R.id.exit:
	        	finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}