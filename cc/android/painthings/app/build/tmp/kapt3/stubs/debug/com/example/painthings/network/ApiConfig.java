package com.example.painthings.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/painthings/network/ApiConfig;", "", "()V", "Companion", "app_debug"})
public final class ApiConfig {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.painthings.network.ApiConfig.Companion Companion = null;
    private static int TIMEOUT_MILLIS = 20000;
    
    public ApiConfig() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/painthings/network/ApiConfig$Companion;", "", "()V", "TIMEOUT_MILLIS", "", "getApiService", "Lcom/example/painthings/network/ApiService;", "getMlApiService", "Lcom/example/painthings/network/MlApiService;", "getWikiArtService", "Lcom/example/painthings/network/WikiArtApiService;", "setupOkhttpInterceptor", "Lokhttp3/OkHttpClient;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.painthings.network.ApiService getApiService() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.painthings.network.MlApiService getMlApiService() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.painthings.network.WikiArtApiService getWikiArtService() {
            return null;
        }
        
        private final okhttp3.OkHttpClient setupOkhttpInterceptor() {
            return null;
        }
    }
}