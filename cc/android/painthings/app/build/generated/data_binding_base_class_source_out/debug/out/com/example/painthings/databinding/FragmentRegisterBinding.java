// Generated by view binder compiler. Do not edit!
package com.example.painthings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.painthings.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegisterBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final MaterialButton btnRegister;

  @NonNull
  public final TextView btnToLogin;

  @NonNull
  public final EditText edBirthDate;

  @NonNull
  public final EditText edEmail;

  @NonNull
  public final EditText edName;

  @NonNull
  public final EditText edPassword;

  @NonNull
  public final ProgressBar registerProgressBar;

  private FragmentRegisterBinding(@NonNull ScrollView rootView, @NonNull MaterialButton btnRegister,
      @NonNull TextView btnToLogin, @NonNull EditText edBirthDate, @NonNull EditText edEmail,
      @NonNull EditText edName, @NonNull EditText edPassword,
      @NonNull ProgressBar registerProgressBar) {
    this.rootView = rootView;
    this.btnRegister = btnRegister;
    this.btnToLogin = btnToLogin;
    this.edBirthDate = edBirthDate;
    this.edEmail = edEmail;
    this.edName = edName;
    this.edPassword = edPassword;
    this.registerProgressBar = registerProgressBar;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_register;
      MaterialButton btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.btn_to_login;
      TextView btnToLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnToLogin == null) {
        break missingId;
      }

      id = R.id.ed_birth_date;
      EditText edBirthDate = ViewBindings.findChildViewById(rootView, id);
      if (edBirthDate == null) {
        break missingId;
      }

      id = R.id.ed_email;
      EditText edEmail = ViewBindings.findChildViewById(rootView, id);
      if (edEmail == null) {
        break missingId;
      }

      id = R.id.ed_name;
      EditText edName = ViewBindings.findChildViewById(rootView, id);
      if (edName == null) {
        break missingId;
      }

      id = R.id.ed_password;
      EditText edPassword = ViewBindings.findChildViewById(rootView, id);
      if (edPassword == null) {
        break missingId;
      }

      id = R.id.registerProgressBar;
      ProgressBar registerProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (registerProgressBar == null) {
        break missingId;
      }

      return new FragmentRegisterBinding((ScrollView) rootView, btnRegister, btnToLogin,
          edBirthDate, edEmail, edName, edPassword, registerProgressBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}