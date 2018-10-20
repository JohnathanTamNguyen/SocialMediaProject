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
//import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{


    public HomeFragment() {
        // Required empty public constructor
    }

//    ViewPager nfViewPager;
//    TabLayout nfTabLayout;
//
//    private FragmentActivity myContext;
//
//    @Override
//    public void onAttach(Activity activity) {
//        myContext=(FragmentActivity) activity;
//        super.onAttach(activity);
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        nfViewPager = (ViewPager) getView().findViewById(R.id.news_feed_vp_frag);
//        nfTabLayout = (TabLayout) getView().findViewById(R.id.news_feed_tab_layout_frag);
//        nfTabLayout.addTab(nfTabLayout.newTab().setText("FEED"));
//        nfTabLayout.addTab(nfTabLayout.newTab().setText("EXPLORE"));
//        nfTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        final PagerAdapter nfPagerAdapter = new PagerAdapter(getFragmentManager() ,nfTabLayout.getTabCount());
//        nfViewPager.setAdapter(nfPagerAdapter);
//        nfViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(nfTabLayout));
//
//        nfTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                nfViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout nfTabLayout = (TabLayout) view.findViewById(R.id.news_feed_tab_layout_frag);
//        nfTabLayout.addTab(nfTabLayout.newTab().setText("FEED"));
//        nfTabLayout.addTab(nfTabLayout.newTab().setText("EXPLORE"));
//        nfTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.news_feed_vp_frag);
        PagerAdapter nfPageAdapter = new PagerAdapter(getChildFragmentManager(), nfTabLayout.getTabCount());
        mViewPager.setAdapter(nfPageAdapter);
    }

    //    public void createTabs(TabLayout nfTabLayout) {
//        nfTabLayout.addTab(nfTabLayout.newTab().setText("FEED"));
//        nfTabLayout.addTab(nfTabLayout.newTab().setText("EXPLORE"));
//        nfTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        final ViewPager nfViewPager = (ViewPager) getView().findViewById(R.id.news_feed_vp_frag);
//        final PagerAdapter nfPagerAdapter = new PagerAdapter(getChildFragmentManager(),nfTabLayout.getTabCount());
//        nfViewPager.setAdapter(nfPagerAdapter);
//        nfViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(nfTabLayout));
//
//        nfTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                nfViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }

}
