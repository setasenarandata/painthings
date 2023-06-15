package com.example.painthings.ui.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020(H\u0016J-\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00172\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050,2\u0006\u0010-\u001a\u00020.H\u0016\u00a2\u0006\u0002\u0010/J\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u00020(H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/example/painthings/ui/detail/DetailFragment;", "Landroidx/fragment/app/Fragment;", "art", "Lcom/example/painthings/network/WikiArtDetailResponse;", "journal", "", "(Lcom/example/painthings/network/WikiArtDetailResponse;Ljava/lang/String;)V", "_binding", "Lcom/example/painthings/databinding/FragmentDetailBinding;", "artist", "binding", "getBinding", "()Lcom/example/painthings/databinding/FragmentDetailBinding;", "description", "image", "myJournal", "shareBtn", "Lcom/google/android/material/button/MaterialButton;", "storageActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "storagePermissionCode", "", "title", "checkPermission", "", "getBitMap", "Landroid/graphics/Bitmap;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermission", "saveAndShareImage", "app_debug"})
public final class DetailFragment extends androidx.fragment.app.Fragment {
    private com.example.painthings.databinding.FragmentDetailBinding _binding;
    private com.google.android.material.button.MaterialButton shareBtn;
    private final java.lang.String title = null;
    private final java.lang.String artist = null;
    private final java.lang.String description = null;
    private final java.lang.String image = null;
    private final java.lang.String myJournal = null;
    private final int storagePermissionCode = 100;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> storageActivityResultLauncher = null;
    
    public DetailFragment(@org.jetbrains.annotations.NotNull()
    com.example.painthings.network.WikiArtDetailResponse art, @org.jetbrains.annotations.NotNull()
    java.lang.String journal) {
        super();
    }
    
    private final com.example.painthings.databinding.FragmentDetailBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void saveAndShareImage() {
    }
    
    private final void requestPermission() {
    }
    
    private final boolean checkPermission() {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final java.lang.Object getBitMap(java.lang.String url, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation) {
        return null;
    }
}