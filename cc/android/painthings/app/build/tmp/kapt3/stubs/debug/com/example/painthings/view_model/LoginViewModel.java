package com.example.painthings.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/painthings/view_model/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "loginRes", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/painthings/network/LoginResponse;", "getLoginStatus", "Landroidx/lifecycle/LiveData;", "getMe", "", "cookie", "", "login", "body", "Lcom/example/painthings/network/LoginBody;", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.painthings.network.LoginResponse> loginRes = null;
    
    public LoginViewModel() {
        super();
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    com.example.painthings.network.LoginBody body) {
    }
    
    public final void getMe(@org.jetbrains.annotations.NotNull()
    java.lang.String cookie) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.painthings.network.LoginResponse> getLoginStatus() {
        return null;
    }
}