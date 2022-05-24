package com.example.bookingfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {

    List<Product> foodList;

    private Context context;
    private int layout;

    public CartAdapter(Context context, int layout, List<Product> listProduct) {
        this.context = context;
        this.layout = layout;
        this.foodList = listProduct;
    }
    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtNameFood;
        ImageView imageViewFood;
        TextView txtPrice;
        EditText amount;
        CheckBox checkBox;


    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;



        if(view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.txtNameFood = (TextView) view.findViewById(R.id.nameFood);
            holder.imageViewFood = (ImageView) view.findViewById(R.id.imageFoodDetail);
            holder.txtPrice = (TextView) view.findViewById(R.id.priceFood);
            //holder.imageButtonDelete = (ImageButton)convertView.findViewById(R.id.delete);
            holder.checkBox = (CheckBox)view.findViewById(R.id.checkBox);
            holder.amount = (EditText) view.findViewById(R.id.amount);

            view.setTag(holder);
        }else{
            holder = (CartAdapter.ViewHolder) view.getTag();
        }


        Product addressStore = (Product) this.getItem(i);


        holder.imageViewFood.setImageResource(addressStore.get_picture());
        holder.txtNameFood.setText(addressStore.get_name());
        holder.txtPrice.setText(""+addressStore.get_price());
        String totalAmount = "" + addressStore.get_idcategory();
        holder.amount.setText(totalAmount);
        holder.checkBox.setChecked(true);
        return view;
    }
}
