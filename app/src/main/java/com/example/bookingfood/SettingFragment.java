package com.example.bookingfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
//        lvCategory = (ListView)rootView.findViewById(R.id.lvCategory);
//        db = new Database(getContext());
//        sqLiteDatabase = db.getReadableDatabase();
//        arrayCategory = new ArrayList<>();
//        initCategory();
//        categoryAdapter = new CategoryAdapter(getContext(), R.layout.layout_custome_category, arrayCategory);
//
//        lvCategory.setAdapter(categoryAdapter);
//
//        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                intent = new Intent(getContext(),FoodActivity.class);
//                intent.putExtra("positionCate", position);
//                startActivity(intent);
//            }
//        });

        return rootView;
    }
}
