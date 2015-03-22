package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BasicDetails extends Fragment {

	@Override
	public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle state) {
	    return layoutInflater.inflate(R.layout.basic_details, container, false);
	}

	public BasicDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	final Button btnAdditional = (Button)getView().findViewById(R.id.additional_fields);	
    btnAdditional.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View vw) { 
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				AdditionalDetails detailsF = (AdditionalDetails)fragmentManager.findFragmentById(R.id.frameLayout2);
				if(detailsF == null){ 
    				fragmentTransaction.add(R.id.frameLayout2 , new AdditionalDetails());
    				btnAdditional.setText("Hide details");
    				
    			} else {
    				
    				fragmentTransaction.remove(detailsF);
    				btnAdditional.setText("Show details");
    				 
    			}
				fragmentTransaction.commit();

    		}
    	});
	}
	
}
