package com.vnlotus.easybooking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.vnlotus.easybooking.R;
import com.vnlotus.easybooking.adapter.GridProductAdapter;
import com.vnlotus.easybooking.objects.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;

public class FragmentA extends BaseFragment {

    @Bind(R.id.menu_spinner) protected Spinner spinner;
    @Bind(R.id.product_list) protected GridView gridProduct;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] data = new String[] {"Food", "Drink", "Sales", "Hot"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        List<Product> products = new ArrayList<>();
        GridProductAdapter gridProductAdapter = new GridProductAdapter(getActivity(), products);
        gridProduct.setAdapter(gridProductAdapter);

        String[] imgUrls = new String[]{
            "http://graphics8.nytimes.com/images/2013/07/14/magazine/14drink_span/mag-14Drink-t-000_CA0-superJumbo.jpg",
            "http://s3.media.squarespace.com/production/1236088/14993829/-aE4HabgxjW0/TgjMkbYboDI/AAAAAAAAABc/5A-SaAfCemo/s1600/MSC%2BCruises%2BHealthy%2BDrinks.jpg",
            "http://www3.imperial.ac.uk/newseventsimages?p_image_type=mainnews2012&p_image_id=23035",
            "http://activia.us.com/images/default-source/product-hero/activia-drinks-strawberry100EE4A2FA9D.png?sfvrsn=0",
            "https://upload.wikimedia.org/wikipedia/commons/c/cf/Tumbler_of_cola_with_ice.jpg",
            "http://www.kiipfit.com/wp-content/uploads/2016/03/mango-chia-drink-1.0.jpg",
            "http://blog.thebrideandgroom.com/wp-content/uploads/2013/06/strawberry-lemonade-0809-lg.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/fb/30/51/fb3051cb1b6c03664f4ff6b650bd9cd5.jpg"
        };
        Random random = new Random();
        for (int i = 0; i < 99; i++) {
            products.add(new Product(imgUrls[random.nextInt(imgUrls.length)], "Product " + i, random.nextInt(100)*1000));
        }

        gridProductAdapter.notifyDataSetChanged();
    }
}