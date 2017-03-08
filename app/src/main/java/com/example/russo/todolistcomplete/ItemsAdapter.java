package com.example.russo.todolistcomplete;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by russo on 08/03/2017.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemVH> {

    ArrayList<Item> list;

    public ItemsAdapter(ArrayList<Item> e){
        list = e;
    }

    public void add(Item i){
        list.add(i);
        notifyDataSetChanged();
    }

    @Override
    public ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new ItemVH(v);
    }

    @Override
    public void onBindViewHolder(ItemVH holder, int position) {
        holder.titolo.setText(list.get(position).getTitolo());
        holder.data.setText(list.get(position).getDataCreazione());
        holder.descrizione.setText(list.get(position).getDescrizione());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemVH extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView titolo, descrizione, data;

        public ItemVH(View itemView) {
            super(itemView);
            titolo = (TextView) itemView.findViewById(R.id.item_Titolo);
            descrizione = (TextView) itemView.findViewById(R.id.item_Descrizione);
            data = (TextView) itemView.findViewById(R.id.item_Data);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater inflater = ((MainActivity)v.getContext()).getMenuInflater();
            inflater.inflate(R.menu.menu_item, menu);
        }
    }
}
