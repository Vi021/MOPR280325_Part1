package vn.iotstar.ltmob280325.Fragment_TabLayout_ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainActBinding;     // spawn magically via data binding (name based of layout .xml)
    private ViewPager2Adapter viewPager2Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // inflate via binder
        mainActBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainActBinding.getRoot());

        setSupportActionBar(mainActBinding.toolBar);
        FloatingActionButton fab = mainActBinding.fab;
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_INDEFINITE)
                                                    .setDuration(500)
                                                    .setAction("Action", null)
                                                    .show());

        String[] tabTitles = {"Xác nhận", "Lấy hàng", "Đang giao", "Đánh giá", "Hủy"};
        for (String title : tabTitles) {
            mainActBinding.tabLayout.addTab(mainActBinding.tabLayout.newTab().setText(title));
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager2Adapter = new ViewPager2Adapter(fragmentManager, getLifecycle());
        mainActBinding.viewPager2.setAdapter(viewPager2Adapter);

        mainActBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainActBinding.viewPager2.setCurrentItem(tab.getPosition());
                changeFabIcon(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        mainActBinding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                mainActBinding.tabLayout.selectTab(mainActBinding.tabLayout.getTabAt(position));
            }
        });
    }

    private void changeFabIcon(final int index) {
        mainActBinding.fab.hide();

        new Handler().postDelayed(() -> {
            if (index == 0) {
                mainActBinding.fab.setImageDrawable(AppCompatResources.getDrawable(this, android.R.drawable.ic_menu_call));
            } else if (index == 1) {
                mainActBinding.fab.setImageDrawable(AppCompatResources.getDrawable(this, android.R.drawable.ic_menu_camera));
            } else if (index == 2) {
                mainActBinding.fab.setImageDrawable(AppCompatResources.getDrawable(this, android.R.drawable.ic_menu_call));
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuSearch) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuNewGroup) {
            Toast.makeText(this, "NewGroup", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuBroadcast) {
            Toast.makeText(this, "New Broadcast", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuWeb) {
            Toast.makeText(this, "WhatsApp Web", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuSettings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}