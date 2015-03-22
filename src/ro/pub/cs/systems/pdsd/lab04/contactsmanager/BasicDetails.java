package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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

		final Button btnSave = (Button)getView().findViewById(R.id.save);	
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View vw) { 

				Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
				intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
				String name = ((EditText)getActivity().findViewById(R.id.name)).getText().toString();
				if (name != null) {
					intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
				}
				String phone = ((EditText)getActivity().findViewById(R.id.phone)).getText().toString();
				if (phone != null) {
					intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
				}
				String email = ((EditText)getActivity().findViewById(R.id.email)).getText().toString();
				if (email != null) {
					intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
				}
				String address = ((EditText)getActivity().findViewById(R.id.address)).getText().toString();
				if (address != null) {
					intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address);
				}
				ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
				String website = ((EditText)getActivity().findViewById(R.id.website)).getText().toString();
				if (website != null) {
					ContentValues websiteRow = new ContentValues();
					websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
					websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website);
					contactData.add(websiteRow);
				}
				String im = ((EditText)getActivity().findViewById(R.id.im)).getText().toString();
				if (im != null) {
					ContentValues imRow = new ContentValues();
					imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
					imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im);
					contactData.add(imRow);
				}
				intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
				getActivity().startActivity(intent);
			}
		});

	}
}
