package com.example.android.socialmediaproject;


import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Feed.OnFragmentInteractionListener, Explore.OnFragmentInteractionListener {

    Boolean test = false;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);


        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout nfTabLayout = (TabLayout) view.findViewById(R.id.news_feed_tab_layout_frag);
        nfTabLayout.addTab(nfTabLayout.newTab().setText("FEED"));
        nfTabLayout.addTab(nfTabLayout.newTab().setText("EXPLORE"));
        nfTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager nfViewPager = (ViewPager) view.findViewById(R.id.news_feed_vp_frag);
        final PagerAdapter nfPagerAdapter = new PagerAdapter(getFragmentManager() ,nfTabLayout.getTabCount());
        nfViewPager.setAdapter(nfPagerAdapter);

        Log.v("HomeFragment", "TEST22222 is" + test);
        nfViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(nfTabLayout));

        nfTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.v("HomeFragment", "POSSSS = " + tab.getPosition());
                nfViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
