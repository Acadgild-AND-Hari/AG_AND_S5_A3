package com.hari.aag.contactslist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import com.hari.aag.contactslist.data.Contact;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hari Nivas Kumar R P on 12/14/2016.
 */

public class ContactsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contact> contactArrayList;

    public ContactsAdapter (Context context, Contact[] contacts){
        this.context = context;
        contactArrayList = new ArrayList<>(Arrays.asList(contacts));
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setText(contactArrayList.get(position).getName());
        text2.setText(contactArrayList.get(position).getPhoneNumber());

        return twoLineListItem;
    }
}
