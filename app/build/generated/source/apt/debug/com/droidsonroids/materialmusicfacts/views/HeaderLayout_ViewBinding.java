// Generated code from Butter Knife. Do not modify!
package com.droidsonroids.materialmusicfacts.views;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.droidsonroids.materialmusicfacts.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class HeaderLayout_ViewBinding<T extends HeaderLayout> implements Unbinder {
  protected T target;

  public HeaderLayout_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mTextViewTitle = finder.findRequiredViewAsType(source, R.id.textview_title, "field 'mTextViewTitle'", TextView.class);
    target.mViewRound = finder.findRequiredView(source, R.id.view_round, "field 'mViewRound'");
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTextViewTitle = null;
    target.mViewRound = null;

    this.target = null;
  }
}
