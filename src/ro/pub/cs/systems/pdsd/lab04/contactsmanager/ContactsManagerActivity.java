package ro.pub.cs.systems.pdsd.lab04.contactsmanager;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.view.View.OnClickListener;
import android.view.View;

public class ContactsManagerActivity extends Activity {
    boolean bAdditional; 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_manager);
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.frameLayout1 , new BasicDetails());
		fragmentTransaction.commit();
		bAdditional = true;
	/*  
	final Button btnAdditional = (Button)findViewById(R.id.additional_fields);	
    btnAdditional.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View vw) { 
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				AdditionalDetails detailsF = (AdditionalDetails)fragmentManager.findFragmentById(R.id.frameLayout2);
				if(detailsF == null){ 
    				fragmentTransaction.add(R.id.frameLayout2 , new AdditionalDetails());
    				btnAdditional.setText("Hide details");
    				bAdditional = true;
    			} else {
    				
    				fragmentTransaction.remove(detailsF);
    				btnAdditional.setText("Show details");
    				bAdditional = false; 
    			}
				fragmentTransaction.commit();

    		}
    	});
	*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contacts_manager, menu);
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
