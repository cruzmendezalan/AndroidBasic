package com.krakenlabs.androidbasic;

import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;
import com.krakenlabs.androidbasic.controllers.Controller;
import com.krakenlabs.androidbasic.databinding.ActivityMainBinding;
import com.krakenlabs.androidbasic.databinding.NavHeaderBinding;
import com.krakenlabs.androidbasic.ui.activity.ActivityModel;
import com.krakenlabs.androidbasic.ui.activity.ActivityViewModel;
import com.krakenlabs.androidbasic.ui.basic.BaseActivity;
import com.krakenlabs.androidbasic.ui.basic.BaseFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Controller            controller;
    private ActivityMainBinding   uiBinding;
    private ActionBarDrawerToggle toggle;
    private NavHeaderBinding      navHeaderBinding;
    private ActivityViewModel     activityViewModel;
    private ActivityModel         activityModel = new ActivityModel();


    private AppFragmentsFactory appFragmentsFactory = new AppFragmentsFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);
        activityViewModel.setActivity(this);
        activityViewModel.setActivityModel(activityModel);
        uiBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        setSupportActionBar(uiBinding.tToolbar);
        // Initialize ActionBarDrawerToggle, which will control toggle of hamburger.
        // You set the values of R.string.open and R.string.close accordingly.
        // Also, you can implement drawer toggle listener if you want.
        toggle = new ActionBarDrawerToggle
          (
            this,
            uiBinding.drawerLayout,
            uiBinding.tToolbar,
            R.string.label_abrir_meenu,
            R.string.label_cerrar_menu
          );

        // Setting the actionbarToggle to drawer layout
        uiBinding.drawerLayout.setDrawerListener(toggle);

        this.toggle.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.toggle.syncState();

        navHeaderBinding  = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header,uiBinding.nvProfile,false);
        navHeaderBinding.setModel(activityModel);
        navHeaderBinding.setViewmodel(activityViewModel);

        uiBinding.nvProfile.setNavigationItemSelectedListener(this);
        uiBinding.nvProfile.addHeaderView(navHeaderBinding.getRoot());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }


    @Override
    public <T extends BaseFragment> void addFragment(T fragment) {
        uiBinding.drawerLayout.closeDrawers();
        Transition transition = new TransitionSet()
          .addTransition(new Slide(Gravity.BOTTOM));
        fragment.setEnterTransition(transition);
        getSupportFragmentManager()
          .beginTransaction()
//          .setCustomAnimations(R.anim.slide_in_bottom, //animaciones
//            android.R.anim.fade_out,
//            android.R.anim.slide_out_right,
//            android.R.anim.fade_out)
          .add(R.id.fl_container,fragment,fragment.getClass().getSimpleName())
          .addToBackStack(fragment.getTag())
          .commit();

    }

    @Override
    public <T extends BaseFragment> void replaceFragment(T fragment) {

    }

    @Override
    public AppFragmentsFactory getFragmentFactory() {
        return appFragmentsFactory;
    }
}
