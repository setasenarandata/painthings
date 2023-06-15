package com.example.painthings.emotions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/painthings/emotions/EmotionsViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "counter", "", "headings", "", "subtitle", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getCounter", "getItemPosition", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "resetCounter", "setCounter", "value", "app_debug"})
public final class EmotionsViewPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private android.content.Context context;
    private int counter = 0;
    private int[] headings = {com.example.painthings.R.string.emotion_heading_1, com.example.painthings.R.string.emotion_heading_2, com.example.painthings.R.string.emotion_heading_3, com.example.painthings.R.string.emotion_heading_4, com.example.painthings.R.string.emotion_heading_5, com.example.painthings.R.string.emotion_heading_6};
    private int[] subtitle = {com.example.painthings.R.string.emotion_subtitle_1, com.example.painthings.R.string.emotion_subtitle_2, com.example.painthings.R.string.emotion_subtitle_3, com.example.painthings.R.string.emotion_subtitle_4, com.example.painthings.R.string.emotion_subtitle_5, com.example.painthings.R.string.emotion_subtitle_6};
    
    public EmotionsViewPagerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isViewFromObject(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    @java.lang.Override()
    public void destroyItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final int setCounter(int value) {
        return 0;
    }
    
    public final void resetCounter() {
    }
    
    @java.lang.Override()
    public int getItemPosition(@org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
        return 0;
    }
}