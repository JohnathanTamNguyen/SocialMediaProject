package com.example.android.socialmediaproject;

//import android.app.Fragment;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Newsfeed extends AppCompatActivity implements Feed.OnFragmentInteractionListener, Explore.OnFragmentInteractionListener {

    public BottomNavigationView mMainNav;
    public HomeFragment homeFragment;
    public NotificationsFragment notificationsFragment;
    public AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        notificationsFragment = new NotificationsFragment();
        accountFragment = new AccountFragment();

        setFragment(homeFragment);

//        final TabLayout nfTabLayout = (TabLayout) findViewById(R.id.news_feed_tab_layout);
//
//        createTabs(nfTabLayout);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        //nfTabLayout.setVisibility(View.VISIBLE);
                        return true;

                    case R.id.nav_notif:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(notificationsFragment);
                        //nfTabLayout.setVisibility(View.GONE);
                        return true;

                    case R.id.nav_account:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(accountFragment);
                        //nfTabLayout.setVisibility(View.GONE);
                        return true;

                    default:
                        return false;

                }

            }

        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.news_feed_vp, fragment);
        fragmentTransaction.commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void createTabs(TabLayout nfTabLayout) {
        nfTabLayout.addTab(nfTabLayout.newTab().setText("FEED"));
        nfTabLayout.addTab(nfTabLayout.newTab().setText("EXPLORE"));
        nfTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager nfViewPager = (ViewPager) findViewById(R.id.news_feed_vp);
        final PagerAdapter nfPagerAdapter = new PagerAdapter(getSupportFragmentManager(),nfTabLayout.getTabCount());
        nfViewPager.setAdapter(nfPagerAdapter);
        nfViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(nfTabLayout));

        nfTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                nfViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
