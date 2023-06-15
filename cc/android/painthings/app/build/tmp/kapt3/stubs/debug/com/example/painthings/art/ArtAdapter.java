package com.example.painthings.art;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001e\u0010\u0013\u001a\u00020\f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0015J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/painthings/art/ArtAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/painthings/art/ArtAdapter$ArtViewHolder;", "()V", "list", "Ljava/util/ArrayList;", "Lcom/example/painthings/network/WikiArtDetailResponse;", "onItemClickCallback", "Lcom/example/painthings/art/ArtAdapter$OnItemClickCallback;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "res", "Lkotlin/collections/ArrayList;", "setOnItemClickCallback", "ArtViewHolder", "OnItemClickCallback", "app_debug"})
public final class ArtAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.painthings.art.ArtAdapter.ArtViewHolder> {
    private final java.util.ArrayList<com.example.painthings.network.WikiArtDetailResponse> list = null;
    private com.example.painthings.art.ArtAdapter.OnItemClickCallback onItemClickCallback;
    
    public ArtAdapter() {
        super();
    }
    
    public final void setOnItemClickCallback(@org.jetbrains.annotations.NotNull()
    com.example.painthings.art.ArtAdapter.OnItemClickCallback onItemClickCallback) {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.painthings.network.WikiArtDetailResponse> res) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.painthings.art.ArtAdapter.ArtViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.painthings.art.ArtAdapter.ArtViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/painthings/art/ArtAdapter$ArtViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/painthings/databinding/ItemArtBinding;", "(Lcom/example/painthings/art/ArtAdapter;Lcom/example/painthings/databinding/ItemArtBinding;)V", "bind", "", "art", "Lcom/example/painthings/network/WikiArtDetailResponse;", "app_debug"})
    public final class ArtViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.painthings.databinding.ItemArtBinding binding = null;
        
        public ArtViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.painthings.databinding.ItemArtBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.painthings.network.WikiArtDetailResponse art) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/example/painthings/art/ArtAdapter$OnItemClickCallback;", "", "onItemClick", "", "data", "Lcom/example/painthings/network/WikiArtDetailResponse;", "title", "Landroid/widget/TextView;", "artist", "year", "paintings", "Landroid/widget/ImageView;", "app_debug"})
    public static abstract interface OnItemClickCallback {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.painthings.network.WikiArtDetailResponse data, @org.jetbrains.annotations.NotNull()
        android.widget.TextView title, @org.jetbrains.annotations.NotNull()
        android.widget.TextView artist, @org.jetbrains.annotations.NotNull()
        android.widget.TextView year, @org.jetbrains.annotations.NotNull()
        android.widget.ImageView paintings);
    }
}