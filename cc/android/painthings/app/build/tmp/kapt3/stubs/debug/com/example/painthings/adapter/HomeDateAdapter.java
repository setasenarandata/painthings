package com.example.painthings.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0017J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/painthings/adapter/HomeDateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/painthings/adapter/HomeDateAdapter$ViewHolder;", "dateList", "", "Lcom/example/painthings/model/HomeDate;", "dateItemClickListener", "Lcom/example/painthings/adapter/HomeDateAdapter$DateItemClickListener;", "(Ljava/util/List;Lcom/example/painthings/adapter/HomeDateAdapter$DateItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DateItemClickListener", "ViewHolder", "app_debug"})
public final class HomeDateAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.painthings.adapter.HomeDateAdapter.ViewHolder> {
    private final java.util.List<com.example.painthings.model.HomeDate> dateList = null;
    private final com.example.painthings.adapter.HomeDateAdapter.DateItemClickListener dateItemClickListener = null;
    
    public HomeDateAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.painthings.model.HomeDate> dateList, @org.jetbrains.annotations.NotNull()
    com.example.painthings.adapter.HomeDateAdapter.DateItemClickListener dateItemClickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.painthings.adapter.HomeDateAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.painthings.adapter.HomeDateAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/painthings/adapter/HomeDateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemBinding", "Lcom/example/painthings/databinding/ItemDateListBinding;", "(Lcom/example/painthings/databinding/ItemDateListBinding;)V", "setData", "", "dateList", "", "Lcom/example/painthings/model/HomeDate;", "position", "", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.painthings.databinding.ItemDateListBinding itemBinding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.painthings.databinding.ItemDateListBinding itemBinding) {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.painthings.model.HomeDate> dateList, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/painthings/adapter/HomeDateAdapter$DateItemClickListener;", "", "onDateItemClicked", "", "date", "Ljava/util/Date;", "app_debug"})
    public static abstract interface DateItemClickListener {
        
        public abstract void onDateItemClicked(@org.jetbrains.annotations.NotNull()
        java.util.Date date);
    }
}