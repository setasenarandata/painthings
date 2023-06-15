package com.example.painthings.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\'J\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u000fH\'J\u001b\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/painthings/network/ApiService;", "", "createPost", "Lretrofit2/Call;", "Lcom/example/painthings/network/CreatePostResponse;", "emotions", "Lcom/example/painthings/network/PostBody;", "fetchCluster", "", "Lcom/example/painthings/network/ArtResponse;", "id", "", "getMe", "Lcom/example/painthings/network/LoginResponse;", "cookie", "", "getPost", "Lcom/example/painthings/network/EmotionResponseItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostByDate", "createdAt", "getPostById", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "loginBody", "Lcom/example/painthings/network/LoginBody;", "register", "Lcom/example/painthings/network/RegisterResponse;", "registerBody", "Lcom/example/painthings/network/RegisterBody;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "login")
    public abstract retrofit2.Call<com.example.painthings.network.LoginResponse> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.painthings.network.LoginBody loginBody);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "users")
    public abstract retrofit2.Call<com.example.painthings.network.RegisterResponse> register(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.painthings.network.RegisterBody registerBody);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "posts")
    public abstract java.lang.Object getPost(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.painthings.network.EmotionResponseItem>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "posts")
    public abstract retrofit2.Call<com.example.painthings.network.CreatePostResponse> createPost(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.painthings.network.PostBody emotions);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "posts/{id}")
    public abstract java.lang.Object getPostById(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.painthings.network.EmotionResponseItem> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "posts/date/{createdAt}")
    public abstract retrofit2.Call<com.example.painthings.network.EmotionResponseItem> getPostByDate(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "createdAt")
    java.lang.String createdAt);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "me")
    public abstract retrofit2.Call<com.example.painthings.network.LoginResponse> getMe(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Cookie")
    java.lang.String cookie);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "art/{id}")
    public abstract retrofit2.Call<java.util.List<com.example.painthings.network.ArtResponse>> fetchCluster(@retrofit2.http.Path(value = "id")
    int id);
}