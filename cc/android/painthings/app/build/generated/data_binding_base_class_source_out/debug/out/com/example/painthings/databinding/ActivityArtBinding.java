// Generated by view binder compiler. Do not edit!
package com.example.painthings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.painthings.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityArtBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar artProgressBar;

  @NonNull
  public final AppCompatButton btRefresh;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RecyclerView rvArtResponse;

  private ActivityArtBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar artProgressBar, @NonNull AppCompatButton btRefresh,
      @NonNull LinearLayout linearLayout, @NonNull RecyclerView rvArtResponse) {
    this.rootView = rootView;
    this.artProgressBar = artProgressBar;
    this.btRefresh = btRefresh;
    this.linearLayout = linearLayout;
    this.rvArtResponse = rvArtResponse;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityArtBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityArtBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_art, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityArtBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.artProgressBar;
      ProgressBar artProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (artProgressBar == null) {
        break missingId;
      }

      id = R.id.btRefresh;
      AppCompatButton btRefresh = ViewBindings.findChildViewById(rootView, id);
      if (btRefresh == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.rvArtResponse;
      RecyclerView rvArtResponse = ViewBindings.findChildViewById(rootView, id);
      if (rvArtResponse == null) {
        break missingId;
      }

      return new ActivityArtBinding((ConstraintLayout) rootView, artProgressBar, btRefresh,
          linearLayout, rvArtResponse);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}