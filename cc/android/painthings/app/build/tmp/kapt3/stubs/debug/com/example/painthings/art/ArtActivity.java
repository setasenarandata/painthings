package com.example.painthings.art;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u001f\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/painthings/art/ArtActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/painthings/art/ArtAdapter;", "binding", "Lcom/example/painthings/databinding/ActivityArtBinding;", "clusterNumber", "", "emotionViewModel", "Lcom/example/painthings/view_model/EmotionViewModel;", "refreshButton", "Landroid/widget/Button;", "fetchArtCluster", "", "cluster", "fetchWikiArt", "it", "", "Lcom/example/painthings/network/ArtResponse;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "predictCluster", "emotions", "Lcom/example/painthings/emotions/Emotions;", "showLoading", "state", "", "app_debug"})
public final class ArtActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.painthings.view_model.EmotionViewModel emotionViewModel;
    private com.example.painthings.databinding.ActivityArtBinding binding;
    private com.example.painthings.art.ArtAdapter adapter;
    private android.widget.Button refreshButton;
    private int clusterNumber = 0;
    
    public ArtActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showLoading(boolean state) {
    }
    
    private final java.lang.Object fetchWikiArt(java.util.List<com.example.painthings.network.ArtResponse> it, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void predictCluster(com.example.painthings.emotions.Emotions emotions) {
    }
    
    private final void fetchArtCluster(int cluster) {
    }
}