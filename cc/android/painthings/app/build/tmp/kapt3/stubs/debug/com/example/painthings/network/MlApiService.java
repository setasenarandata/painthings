package com.example.painthings.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/painthings/network/MlApiService;", "", "predictCluster", "Lretrofit2/Call;", "Lcom/example/painthings/network/PredictResponse;", "emotions", "Lcom/example/painthings/emotions/Emotions;", "app_debug"})
public abstract interface MlApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "predict")
    public abstract retrofit2.Call<com.example.painthings.network.PredictResponse> predictCluster(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.painthings.emotions.Emotions emotions);
}