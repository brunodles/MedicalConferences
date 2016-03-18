package com.github.brunodles.medicalconferences.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.brunodles.medicalconferences.R;
import com.github.brunodles.medicalconferences.repositories.dtos.Contact;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bruno on 16/03/16.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    List<Contact> list = Collections.emptyList();

    public void setList(List<Contact> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_contact, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = list.get(position);
        holder.update(contact);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name) TextView name;
        @Bind(R.id.email) TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void update(Contact contact) {
            name.setText(contact.name);
            email.setText(contact.email);
        }
    }
}
