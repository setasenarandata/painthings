package com.example.painthings.onboarding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0015R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/painthings/onboarding/OnboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dots", "", "Landroid/widget/TextView;", "[Landroid/widget/TextView;", "mDotLayout", "Landroid/widget/LinearLayout;", "mSLideViewPager", "Landroidx/viewpager/widget/ViewPager;", "nextButton", "Landroid/widget/Button;", "skipButton", "viewListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewModel", "Lcom/example/painthings/view_model/LoginViewModel;", "viewPagerAdapter", "Lcom/example/painthings/onboarding/ViewPagerAdapter;", "getItem", "", "i", "getMe", "", "cookie", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupIndicator", "position", "app_debug"})
public final class OnboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.viewpager.widget.ViewPager mSLideViewPager;
    private android.widget.LinearLayout mDotLayout;
    private android.widget.TextView[] dots;
    private com.example.painthings.onboarding.ViewPagerAdapter viewPagerAdapter;
    private android.widget.Button nextButton;
    private android.widget.Button skipButton;
    private com.example.painthings.view_model.LoginViewModel viewModel;
    private androidx.viewpager.widget.ViewPager.OnPageChangeListener viewListener;
    
    public OnboardActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setupIndicator(int position) {
    }
    
    private final int getItem(int i) {
        return 0;
    }
    
    private final void getMe(java.lang.String cookie) {
    }
}