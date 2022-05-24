package com.example.bookingfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AddressAdapter extends BaseAdapter {

    List<Address> mlist;

    private Context context;
    private int layout;

    public AddressAdapter(Context context, int layout, List<Address> arrayAddress) {
        this.context = context;
        this.layout = layout;
        this.mlist = arrayAddress;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    class ViewHolder{
        TextView txtAdrress;
        ImageView imageViewFood;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_custome, parent, false);
            holder.txtAdrress = (TextView) convertView.findViewById(R.id.address);
            holder.imageViewFood = (ImageView) convertView.findViewById(R.id.imageViewCustome);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Address addressStore = (Address)this.getItem(position);
        holder.txtAdrress.setText(addressStore.get_description());
        //int imgId = addressStore.get_picture();
        holder.imageViewFood.setImageResource(addressStore.get_picture());
        //byte[] image = addressStore.get_picture();
        ///Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        //holder.imageViewFood.setImageBitmap(bitmap);
        return convertView;
    }
    //filter
    public void filter(String charText)
    {

        charText = charText.toLowerCase(Locale.getDefault());
        if (charText.length() != 0){
            List<Address> filter = new ArrayList<>();

            for(Address adr: mlist){
                //List<Address> mlist = new ArrayList<>();
                if(adr.get_description().toLowerCase(Locale.getDefault()).contains(charText)){
                    filter.add(adr);
                }
            }
            mlist.clear();
            mlist.addAll(filter);
        }
        notifyDataSetChanged();
        //mlist.clear();
    }
}
