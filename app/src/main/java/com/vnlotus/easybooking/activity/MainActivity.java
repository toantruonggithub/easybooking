package com.vnlotus.easybooking.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.vnlotus.easybooking.R;
import com.vnlotus.easybooking.adapter.TabsAdapter;
import com.vnlotus.easybooking.animation.ZoomOutPageTransformer;
import com.vnlotus.easybooking.fragment.FragmentA;
import com.vnlotus.easybooking.fragment.FragmentB;
import com.vnlotus.easybooking.fragment.FragmentC;

import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

  private final Context context = this;

  private AtomicBoolean isCollapse;

  private Animation menuIn, menuOut;

  @Bind(R.id.toggle_view) protected View toggleView;
  @Bind(R.id.button_toggle) protected View buttonToggle;
  @Bind(R.id.viewpager) protected ViewPager viewPager;
  @Bind(R.id.tabs) protected TabLayout tabLayout;

  private Animation.AnimationListener animationInListener = new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
      toggleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
  };

  private Animation.AnimationListener animationOutListener = new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
      toggleView.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
  };

  private int[] tabIcons = {
      R.drawable.ic_lightbulb,
      R.drawable.ic_lightbulb,
      R.drawable.ic_lightbulb,
  };

  private String[] tabTitle;
  private TabsAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    menuIn = AnimationUtils.loadAnimation(this, R.anim.menu_in);
    menuOut = AnimationUtils.loadAnimation(this, R.anim.menu_out);

    menuIn.setAnimationListener(animationInListener);
    menuOut.setAnimationListener(animationOutListener);

    buttonToggle.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (isCollapse.get()) {
          toggleView.startAnimation(menuIn);
          isCollapse.set(false);
        } else {
          toggleView.startAnimation(menuOut);
          isCollapse.set(true);
        }
      }
    });

    setupViewPager(viewPager);

    tabLayout.setupWithViewPager(viewPager);
    setupTabIcons();

    tabTitle = getResources().getStringArray(R.array.tab_titles);

    viewPager.addOnPageChangeListener(this);
    viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
  }

  @Override
  protected void onStart() {
    super.onStart();

    toggleView.startAnimation(menuOut);
    isCollapse = new AtomicBoolean(true);
  }

  private void setupTabIcons() {
    tabLayout.getTabAt(0).setIcon(tabIcons[0]);
    tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    tabLayout.getTabAt(2).setIcon(tabIcons[2]);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    return false;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.menu_main_setting) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void setupViewPager(ViewPager viewPager) {
    adapter = new TabsAdapter(getSupportFragmentManager());
    adapter.addFrag(new FragmentA(), null);
    adapter.addFrag(new FragmentB(), null);
    adapter.addFrag(new FragmentC(), null);
    viewPager.setAdapter(adapter);
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

  }

  @Override
  public void onPageSelected(int position) {
  }

  @Override
  public void onPageScrollStateChanged(int state) {

  }
}
