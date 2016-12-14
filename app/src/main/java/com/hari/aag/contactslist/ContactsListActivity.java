package com.hari.aag.contactslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hari.aag.contactslist.adapter.ContactsAdapter;
import com.hari.aag.contactslist.data.Contact;

public class ContactsListActivity extends AppCompatActivity {

    private final Contact[] contacts = new Contact[]{
            new Contact("Abinaya", "+919121522521"),
            new Contact("Bala", "+919121522522"),
            new Contact("Gautham", "+919121522523"),
            new Contact("Roshan", "+919121522524"),
            new Contact("Joe", "+919121522525"),
            new Contact("Meruna", "+919121522526"),
            new Contact("Dinakar", "+919121522527"),
            new Contact("Dharshika", "+919121522528"),
            new Contact("Manoj", "+919121522529"),
            new Contact("Kannan", "+919121522520")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        ListView contactsListView = (ListView)findViewById(R.id.id_list_contacts);
        contactsListView.setAdapter(new ContactsAdapter(this, contacts));
        registerForContextMenu(contactsListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_options_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.id_call:
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + contacts[info.position].getPhoneNumber()));
                Toast.makeText(this, "Making Call to " + contacts[info.position].getName() + " ...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_sms:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:" + contacts[info.position].getPhoneNumber()));
                Toast.makeText(this, "Sending Sms to " + contacts[info.position].getName() + " ...",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }

        try {
            startActivity(intent);
        } catch (SecurityException e){
            e.printStackTrace();
        }
        return true;
    }
}
