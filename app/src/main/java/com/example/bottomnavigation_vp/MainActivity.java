package com.example.bottomnavigation_vp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
BottomNavigationView buttomng;
PageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.vp);
        buttomng=(BottomNavigationView) findViewById(R.id.bottom);
        pageAdapter=new PageAdapter(getSupportFragmentManager(),buttomng.getMaxItemCount());
        viewPager.setAdapter(pageAdapter);
       // setUpViewPager();
        //pageAdapter=new PageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
       // viewPager.setAdapter(pageAdapter);
        buttomng.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp1,temp2,temp3; ;
                switch (item.getItemId()) {

                    case R.id.home:
                        //temp1 =new tab1();
                        viewPager.setCurrentItem(0);
                        pageAdapter.notifyDataSetChanged();
                        //Toast.makeText(MainActivity.this,"HOME",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.call:
                        //temp2 = new tab2();
                        viewPager.setCurrentItem(1);
                        pageAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,"fav",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.search:
                        //temp3 = new tab3();
                        viewPager.setCurrentItem(2);
                        pageAdapter.notifyDataSetChanged();
                        // Toast.makeText(MainActivity.this,"myy",Toast.LENGTH_LONG).show();


                }
                //viewPager.setCurrentItem(temp.getId());
                //if (getString(temp.getId()) == "home" || getString(temp.getId()) == "call" || getString(temp.getId()) == "search") {
                   // pageAdapter.notifyDataSetChanged();
              //  }
                return true;

            }


        });
        //viewPager.addOnPageChangeListener();
    }

    private void setUpViewPager() {
        pageAdapter=new PageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            switch (position){
                case 0:
                    buttomng.getMenu().findItem(R.id.home).setChecked(true);
                    break;
                case 1:
                    buttomng.getMenu().findItem(R.id.call).setChecked(true);
                    break;
                case 2:
                    buttomng.getMenu().findItem(R.id.search).setChecked(true);
                    break;

            }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}