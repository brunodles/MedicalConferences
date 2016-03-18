package com.github.brunodles.medicalconferences.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.github.brunodles.medicalconferences.R;
import com.github.brunodles.medicalconferences.adapters.ContactAdapter;
import com.github.brunodles.medicalconferences.repositories.dtos.Contact;
import com.github.brunodles.medicalconferences.util.LogRx;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

import static rx.schedulers.Schedulers.computation;

public class ContactActivity extends AppCompatActivity {
    private static final String TAG = "ContactActivity";

    @Bind(R.id.name) EditText name;
    @Bind(R.id.email) EditText email;
    @Bind(R.id.register) Button register;
    @Bind(R.id.list) RecyclerView list;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        contactAdapter = new ContactAdapter();
        list.setAdapter(contactAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateContactList();
    }

    private void updateContactList() {
        Observable.just(new Select().from(Contact.class))
                .observeOn(computation())
                .map(this::execute)
                .doOnNext(contactAdapter::setList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(a -> contactAdapter.notifyDataSetChanged(), LogRx.e(TAG, "updateContactList"));
    }

    private List<Contact> execute(From from) {
        return from.execute();
    }

    @OnClick(R.id.register)
    public void onClick() {
        Contact contact = new Contact();
        contact.name = name.getText().toString();
        contact.email = email.getText().toString();
        contact.save();
    }
}
