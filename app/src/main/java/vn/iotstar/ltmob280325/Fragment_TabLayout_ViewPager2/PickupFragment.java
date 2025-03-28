package vn.iotstar.ltmob280325.Fragment_TabLayout_ViewPager2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.databinding.FragmentPickupBinding;

public class PickupFragment extends Fragment {
    FragmentPickupBinding fragPickupBinding;

    public PickupFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragPickupBinding = FragmentPickupBinding.inflate(inflater, container, false);
        return fragPickupBinding.getRoot();
    }
}