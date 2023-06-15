package com.example.painthings.emotions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/painthings/emotions/EmotionsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "backButton", "Landroid/widget/Button;", "counterValues", "", "", "dots", "", "Landroid/widget/TextView;", "[Landroid/widget/TextView;", "mDotLayout", "Landroid/widget/LinearLayout;", "mSLideViewPager", "Landroidx/viewpager/widget/ViewPager;", "nextButton", "viewListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPagerAdapter", "Lcom/example/painthings/emotions/EmotionsViewPagerAdapter;", "getItem", "i", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupIndicator", "position", "app_debug"})
public final class EmotionsActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.viewpager.widget.ViewPager mSLideViewPager;
    private android.widget.LinearLayout mDotLayout;
    private android.widget.TextView[] dots;
    private com.example.painthings.emotions.EmotionsViewPagerAdapter viewPagerAdapter;
    private android.widget.Button nextButton;
    private android.widget.Button backButton;
    private final java.util.List<java.lang.Integer> counterValues = null;
    private androidx.viewpager.widget.ViewPager.OnPageChangeListener viewListener;
    
    public EmotionsActivity() {
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
}