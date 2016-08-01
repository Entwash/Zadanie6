package com.droidsonroids.materialmusicfacts.screens.screen_main;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.droidsonroids.materialmusicfacts.App;
import com.droidsonroids.materialmusicfacts.R;
import com.droidsonroids.materialmusicfacts.SuperActivity;
import com.droidsonroids.materialmusicfacts.data.MadonnaProvider;
import com.droidsonroids.materialmusicfacts.screens.AlbumDetailsActivity.AlbumDetailsActivity;
import com.droidsonroids.materialmusicfacts.views.SpacesItemDecoration;
import com.squareup.picasso.Picasso;

//Nie wiem czy jest sens robić review tego kodu, bo sam nie ogarniam co tu się dzieje i co tu jest napisane :<
public class MainActivity extends SuperActivity implements AppBarLayout.OnOffsetChangedListener, OnAlbumClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.AppBarLayout)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.details_layout)
    LinearLayout mLayoutDetails;

    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.textview_biography)
    TextView mTextViewBiography;

    private MainRecyclerViewAdapter mAdapter;


    public static void startActivity(final Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeRecyclerView();
        mAppBarLayout.addOnOffsetChangedListener(this);
        mTextViewBiography.setText(R.string.biography);
    }

    private void initializeRecyclerView() {
        mAdapter = new MainRecyclerViewAdapter(Picasso.with(this));
        mAdapter.setOnAlbumClickListener(this);

        mRecyclerView.addItemDecoration(new SpacesItemDecoration(4,5,false));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setAlbumCovers(App.getMadonnaProvider().provideAlbumCovers());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        int maxScroll = mAppBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) / (float)maxScroll;
        if(percentage <= 0.7 && mLayoutDetails.isShown())
            mLayoutDetails.setVisibility(View.VISIBLE);
        else if(percentage > 0.7 && !mLayoutDetails.isShown())
            mLayoutDetails.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onAlbumClickedListener(View imageViewAlbum, int position) {
        ActivityOptions optionsCompat =
                ActivityOptions.makeSceneTransitionAnimation(this, new Pair<View, String>(imageViewAlbum, "transitionAlbum"));
        Intent intent = new Intent(this, AlbumDetailsActivity.class);
        intent.putExtra(AlbumDetailsActivity.EXTRA_ALBUM_COVER, position);
        startActivity(intent, optionsCompat.toBundle());
    }
}
