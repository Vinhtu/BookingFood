package com.example.bookingfood;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }




    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private Database db;
    private SQLiteDatabase sqLiteDatabase;
    ListView listProduct;
    ArrayList<Product> arrListProduct;
    ProductAdapter productAdapter;
    Intent intentBack;
    Intent intentFood;
    SearchView searchView;
    //TextView textViewAddress;
    int dem = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        listProduct = (ListView)rootView.findViewById(R.id.lvProduct);

//        searchView = (SearchView) rootView.findViewById(R.id.searchAddress);
//        //textViewAddress = (TextView) rootView.findViewById(R.id.address);
        arrListProduct = new ArrayList<>();
        db = new Database(getContext());
        sqLiteDatabase = db.getReadableDatabase();
        Cursor dataProductStore = db.GetData("SELECT * FROM PRODUCT");


        while (dataProductStore.moveToNext()){
            arrListProduct.add(new Product(dataProductStore.getInt(0),
                    dataProductStore.getString(1), dataProductStore.getString(2),dataProductStore.getString(3),dataProductStore.getInt(4),dataProductStore.getInt(5)));

        }

        productAdapter = new ProductAdapter(getContext(),R.layout.layout_custom_product, arrListProduct);
        listProduct.setAdapter(productAdapter);


        listProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                intentFood = new Intent(getContext(),ProductDetailActivity.class);
                intentFood.putExtra("positionProduct", position);

                startActivity(intentFood);
            }
        });





//        while (dataAddressStore.moveToNext()){
//            arrayAddress.add(new Address(dataAddressStore.getInt(0),
//                    dataAddressStore.getString(1),
//                    dataAddressStore.getInt(2)
//            ));
//        }
//        addressAdapter = new AddressAdapter(getContext(), R.layout.layout_custome, arrayAddress);

//        lvAddress.setAdapter(addressAdapter);
        //addressAdapter.notifyDataSetChanged();
        //lvAddress.setTextFilterEnabled(true);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if(dem != 0)
//                {
//                    arrayAddress.clear();
//                    Cursor dataAddressStore = db.GetData("SELECT * FROM ADDRESS");
//
//                    while (dataAddressStore.moveToNext()){
//                        arrayAddress.add(new Address(dataAddressStore.getInt(0),
//                                dataAddressStore.getString(1),
//                                dataAddressStore.getInt(2)
//                        ));
//                    }
//                    addressAdapter.clear();
//                    addressAdapter = new AddressAdapter(getContext(), R.layout.layout_custome, arrayAddress);
//
//                }
//                addressAdapter.filter(newText);
//                //lvAddress.setAdapter(addressAdapter);
//                dem++;
//                return true;
//            }
//        });
//        lvAddress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Address address = arrayAddress.get(position);
//                Toast.makeText(rootView.getContext(), address.getDescription(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
        return rootView;
    }

}
