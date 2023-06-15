package com.example.painthings.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/painthings/view_model/ChartViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "chartRes", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/painthings/network/EmotionResponseItem;", "wikiArt", "Lcom/example/painthings/network/WikiArtDetailResponse;", "getArtDetails", "", "artId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArtStatus", "Landroidx/lifecycle/LiveData;", "getChart", "date", "getChartStatus", "app_debug"})
public final class ChartViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.painthings.network.EmotionResponseItem> chartRes = null;
    private final androidx.lifecycle.MutableLiveData<com.example.painthings.network.WikiArtDetailResponse> wikiArt = null;
    
    public ChartViewModel() {
        super();
    }
    
    public final void getChart(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getArtDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String artId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.painthings.network.EmotionResponseItem> getChartStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.painthings.network.WikiArtDetailResponse> getArtStatus() {
        return null;
    }
}