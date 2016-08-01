// Generated code from Butter Knife. Do not modify!
package com.droidsonroids.materialmusicfacts.screens.screen_main;

import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.droidsonroids.materialmusicfacts.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainViewHolder_ViewBinding<T extends MainViewHolder> implements Unbinder {
  protected T target;

  public MainViewHolder_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.imageViewAlbum = finder.findRequiredViewAsType(source, R.id.imageview_album, "field 'imageViewAlbum'", ImageView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imageViewAlbum = null;

    this.target = null;
  }
}
