package com.vnlotus.easybooking.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.vnlotus.easybooking.R;

import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

  private final Context context = this;

  private AtomicBoolean isCollapse;

  private Animation menuIn, menuOut;

  @Bind(R.id.toggle_view) protected View toggleView;
  @Bind(R.id.button_toggle) protected View buttonToggle;

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    menuIn = AnimationUtils.loadAnimation(this, R.anim.menu_in);
    menuOut = AnimationUtils.loadAnimation(this, R.anim.menu_out);

    toggleView.startAnimation(menuOut);
    isCollapse = new AtomicBoolean(true);

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
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    return true;
  }
}
