package vn.iotstar.ltmob280325.Fragment_TabLayout_ViewPager2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.databinding.FragmentNewOrderBinding;

public class NewOrderFragment extends Fragment {
    FragmentNewOrderBinding fragNewOrderBinding;    // only data binding available

    public NewOrderFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragNewOrderBinding = FragmentNewOrderBinding.inflate(inflater, container, false);
        return fragNewOrderBinding.getRoot();
    }
}