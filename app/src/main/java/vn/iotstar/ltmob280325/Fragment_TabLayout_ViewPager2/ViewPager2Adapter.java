package vn.iotstar.ltmob280325.Fragment_TabLayout_ViewPager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new PickupFragment();
        } else if (position == 2) {
            return new DelieveryFragment();
        } else if (position == 3) {
            return new ReviewFragment();
        } else if (position == 4) {
            return new CancelFragment();
        } else {
            return new NewOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;   // for 5 fragments
    }
}
