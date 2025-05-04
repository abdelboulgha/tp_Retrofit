package com.example.tp_api_rest_avec_retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_api_rest_avec_retrofit.R;
import com.example.tp_api_rest_avec_retrofit.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> implements Filterable {

    private List<User> userList;
    private List<User> userListFull; // Liste complète pour le filtrage

    // Ajout d'un constructeur
    public UserAdapter() {
        this.userList = new ArrayList<>();
        this.userListFull = new ArrayList<>();
    }

    public void setUserList(List<User> users) {
        this.userList = users;
        this.userListFull = new ArrayList<>(users); // Copie pour le filtrage
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, phone, city;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.userEmail);
            phone = itemView.findViewById(R.id.userPhone);
            city = itemView.findViewById(R.id.userCity);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());

        // Ajouter la ville depuis l'objet address
        if (user.getAddress() != null && user.getAddress().getCity() != null) {
            holder.city.setText("Ville: " + user.getAddress().getCity());
        } else {
            holder.city.setText("Ville: Non disponible");
        }
    }

    @Override
    public int getItemCount() {
        return (userList == null) ? 0 : userList.size();
    }

    @Override
    public Filter getFilter() {
        return userFilter;
    }

    private Filter userFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<User> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(userListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (User user : userListFull) {
                    // Filtrage par nom
                    if (user.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(user);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            userList.clear();
            userList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}