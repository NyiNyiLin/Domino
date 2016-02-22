package com.nyi.domino.domino;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by IN-3442 on 12-Oct-15.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.KeyHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private static ArrayList<Cold_Drink> Order_List;
    private static MyClickListener myClickListener;

    @Override
    public KeyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);

        KeyHolder keyHolder = new KeyHolder(view);
        return keyHolder;
    }

    @Override
    public void onBindViewHolder(KeyHolder holder, int position) {
        holder.name.setText(Order_List.get(position).getName());
        holder.quantity.setText(Order_List.get(position).getQuantity()+"");
        holder.rate.setText(Order_List.get(position).getRate()+"");
        holder.amount.setText(Order_List.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {

        return Order_List.size();
    }
   /* public void addKey(CustomKey dataObj, int index) {
        Order_List.add(index, dataObj);
        notifyItemInserted(index);
    }*/

    public void deleteKey(int index) {
        Order_List.remove(index);
        notifyItemRemoved(index);
    }
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public CardViewAdapter(ArrayList<Cold_Drink> order_List) {
        Order_List =order_List;
    }

    public static class KeyHolder extends RecyclerView.ViewHolder
            implements OnClickListener{

        TextView name,quantity,rate,amount;
        ImageButton delete;

        public KeyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textview_name_in_cardview);
            quantity = (TextView) itemView.findViewById(R.id.textview_quantity_in_cardview);
            rate=(TextView) itemView.findViewById(R.id.textview_rate_in_cardview);
            amount=(TextView) itemView.findViewById(R.id.textview_amount_in_cardview);
            delete=(ImageButton)itemView.findViewById(R.id.row_delete);

            Log.i(LOG_TAG, "Adding Listener");
            //itemView.setOnClickListener(this);
            delete.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);

        }
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static ArrayList<Cold_Drink> getOrder_List() {
        return Order_List;
    }
}
