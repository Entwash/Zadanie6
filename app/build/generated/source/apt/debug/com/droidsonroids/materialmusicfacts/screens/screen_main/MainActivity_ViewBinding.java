// Generated code from Butter Knife. Do not modify!
package com.droidsonroids.materialmusicfacts.screens.screen_main;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.droidsonroids.materialmusicfacts.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  public MainActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mTextViewBiography = finder.findRequiredViewAsType(source, R.id.textView_biography, "field 'mTextViewBiography'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTextViewBiography = null;

    this.target = null;
  }
}
