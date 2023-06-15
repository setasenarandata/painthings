package com.example.painthings.emotions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/painthings/emotions/CreateNewPost;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "artist", "Landroid/widget/TextView;", "buttonPost", "Landroid/widget/Button;", "journalEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "myBinding", "Lcom/example/painthings/databinding/ActivityCreateNewPostBinding;", "paintings", "Landroid/widget/ImageView;", "title", "viewModel", "Lcom/example/painthings/view_model/EmotionViewModel;", "year", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "post", "array", "", "id", "", "showLoading", "state", "", "Companion", "app_debug"})
public final class CreateNewPost extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.painthings.emotions.CreateNewPost.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_YEAR = "extra_year";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ARTIST = "extra_artist";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TITLE = "extra_title";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_PAINTINGS = "extra_paintings";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ID = "extra_id";
    private android.widget.TextView year;
    private android.widget.TextView artist;
    private android.widget.TextView title;
    private android.widget.ImageView paintings;
    private android.widget.Button buttonPost;
    private com.google.android.material.textfield.TextInputEditText journalEditText;
    private com.example.painthings.databinding.ActivityCreateNewPostBinding myBinding;
    private com.example.painthings.view_model.EmotionViewModel viewModel;
    
    public CreateNewPost() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showLoading(boolean state) {
    }
    
    private final void post(int[] array, java.lang.String id) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/painthings/emotions/CreateNewPost$Companion;", "", "()V", "EXTRA_ARTIST", "", "EXTRA_ID", "EXTRA_PAINTINGS", "EXTRA_TITLE", "EXTRA_YEAR", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}