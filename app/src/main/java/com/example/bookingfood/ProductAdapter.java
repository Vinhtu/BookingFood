package com.example.bookingfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    public ProductAdapter(Context context, int layout, List<Product> listProduct) {
        this.context = context;
        this.layout = layout;
        this.listProduct = listProduct;
    }

    private List<Product> listProduct;
    @Override
    public int getCount() {
        return listProduct.size();
    }


    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView nameFood;
        ImageView imageViewFood;
        TextView txtPrice;
        TextView txtAmount;
        RatingBar ratingBar;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.nameFood = (TextView)view.findViewById(R.id.nameFood);
            holder.imageViewFood = (ImageView) view.findViewById(R.id.imageFood);
            holder.txtPrice = (TextView) view.findViewById(R.id.priceFood);
//            holder.txtAmount = (TextView)view.findViewById(R.id.amountRating);
//            holder.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar2);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }


        Product product = (Product) this.getItem(i);

//        Product product = listProduct.get(i);
        holder.nameFood.setText(product.get_name());

        holder.imageViewFood.setImageResource(product.get_picture());
        holder.txtPrice.setText(product.get_price());




        return view;

    }
}
