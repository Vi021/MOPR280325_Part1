package vn.iotstar.ltmob280325.Fragment_TabLayout_ViewPager2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.iotstar.ltmob280325.databinding.FragmentReviewBinding;

public class ReviewFragment extends Fragment {
    FragmentReviewBinding fragReviewBinding;

    public ReviewFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragReviewBinding = FragmentReviewBinding.inflate(inflater, container, false);
        return fragReviewBinding.getRoot();
    }
}