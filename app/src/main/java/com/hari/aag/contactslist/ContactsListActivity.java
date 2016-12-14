package com.hari.aag.contactslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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

        ((ListView)findViewById(R.id.id_list_contacts)).setAdapter(new ContactsAdapter(this, contacts));
    }
}
