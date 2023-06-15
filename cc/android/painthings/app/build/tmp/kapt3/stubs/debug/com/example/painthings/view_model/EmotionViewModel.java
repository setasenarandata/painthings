package com.example.painthings.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0019J\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\u001d0\u0019J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/example/painthings/view_model/EmotionViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "clusterContainer", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/painthings/network/ArtResponse;", "finalArt", "Ljava/util/ArrayList;", "Lcom/example/painthings/network/WikiArtDetailResponse;", "postRes", "Lcom/example/painthings/network/CreatePostResponse;", "resCluster", "Lcom/example/painthings/network/PredictResponse;", "callWikiArt", "", "it", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCluster", "cluster", "", "getCluster", "emotions", "Lcom/example/painthings/emotions/Emotions;", "getClusterContainer", "Landroidx/lifecycle/LiveData;", "getPostStatus", "getResCluster", "getWikiArtList", "Lkotlin/collections/ArrayList;", "postJournal", "data", "Lcom/example/painthings/network/PostBody;", "app_debug"})
public final class EmotionViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.painthings.network.PredictResponse> resCluster = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.painthings.network.ArtResponse>> clusterContainer = null;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.painthings.network.WikiArtDetailResponse>> finalArt = null;
    private final androidx.lifecycle.MutableLiveData<com.example.painthings.network.CreatePostResponse> postRes = null;
    
    public EmotionViewModel() {
        super();
    }
    
    public final void getCluster(@org.jetbrains.annotations.NotNull()
    com.example.painthings.emotions.Emotions emotions) {
    }
    
    public final void fetchCluster(int cluster) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object callWikiArt(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.painthings.network.ArtResponse> it, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.painthings.network.PredictResponse> getResCluster() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.painthings.network.ArtResponse>> getClusterContainer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<com.example.painthings.network.WikiArtDetailResponse>> getWikiArtList() {
        return null;
    }
    
    public final void postJournal(@org.jetbrains.annotations.NotNull()
    com.example.painthings.network.PostBody data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.painthings.network.CreatePostResponse> getPostStatus() {
        return null;
    }
}