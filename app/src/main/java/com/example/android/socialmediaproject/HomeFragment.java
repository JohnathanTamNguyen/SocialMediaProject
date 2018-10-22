package com.example.android.socialmediaproject;


import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
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
public class HomeFragment extends Fragment {

    TabLayout nfTabLayout;
    TabItem feedTab;
    TabItem exploreTab;
    ViewPager nfViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        nfTabLayout = rootView.findViewById(R.id.news_feed_tab_layout_frag);
        feedTab = rootView.findViewById(R.id.feed_tab);
        exploreTab = rootView.findViewById(R.id.explore_tab);
        nfViewPager = rootView.findViewById(R.id.news_feed_vp_frag);

        PagerAdapter nfPagerAdapter = new PagerAdapter(getChildFragmentManager() ,nfTabLayout.getTabCount());
        nfViewPager.setAdapter(nfPagerAdapter);

        nfTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                nfViewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(TabLayout.Tab tab) {

            }

            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        nfViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(nfTabLayout));

        return rootView;

    }

}
