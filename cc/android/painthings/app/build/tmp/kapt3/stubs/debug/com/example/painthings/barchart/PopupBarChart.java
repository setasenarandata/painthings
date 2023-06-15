package com.example.painthings.barchart;

import java.lang.System;

@android.annotation.SuppressLint(value = {"WrongConstant"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010v\u001a\u00020wJ\u0010\u0010x\u001a\u00020w2\u0006\u0010I\u001a\u00020(H\u0002J\u0018\u0010y\u001a\u00020w2\u0006\u0010z\u001a\u00020\b2\u0006\u0010{\u001a\u00020\bH\u0002J \u0010|\u001a\u00020w2\u0006\u0010I\u001a\u00020(2\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0002J\u0018\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0002J\u0013\u0010\u0080\u0001\u001a\u00020w2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\u0013\u0010\u0083\u0001\u001a\u00020w2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020w2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0014J\u001b\u0010\u0085\u0001\u001a\u00020w2\u0007\u0010\u0086\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020\bH\u0014J\u0011\u0010\u0088\u0001\u001a\u00020w2\u0006\u0010K\u001a\u00020JH\u0002J\u0011\u0010\u0089\u0001\u001a\u00020w2\u0006\u0010P\u001a\u00020\bH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020w2\u0007\u0010\u008b\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020w2\u0007\u0010\u008b\u0001\u001a\u00020\bH\u0002J\u0017\u0010\u008d\u0001\u001a\u00020w2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u0002020\u008f\u0001J\u0012\u0010\u0090\u0001\u001a\u00020w2\u0007\u0010\u008b\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020w2\u0007\u0010\u008b\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020w2\u0007\u0010\u008b\u0001\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u000e\u0010-\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010K\u001a\u00020J2\u0006\u0010\u000b\u001a\u00020J@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000e\"\u0004\bR\u0010\u0010R\u000e\u0010S\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000e\"\u0004\bV\u0010\u0010R\u000e\u0010W\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010Y\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010\u0010R\u000e\u0010\\\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010_\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000e\"\u0004\ba\u0010\u0010R$\u0010b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u000e\"\u0004\bd\u0010\u0010R$\u0010e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000e\"\u0004\bg\u0010\u0010R$\u0010h\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000e\"\u0004\bj\u0010\u0010R$\u0010k\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u000e\"\u0004\bm\u0010\u0010R$\u0010n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u000e\"\u0004\bp\u0010\u0010R\u000e\u0010q\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/example/painthings/barchart/PopupBarChart;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animateAllIndex", "", "barHeight", "", "value", "barSize", "getBarSize", "()I", "setBarSize", "(I)V", "barTextColor", "getBarTextColor", "setBarTextColor", "barTextFontFamily", "getBarTextFontFamily", "setBarTextFontFamily", "barTextSize", "getBarTextSize", "setBarTextSize", "barWidth", "bgPaintList", "Ljava/util/ArrayList;", "Landroid/graphics/Paint;", "Lkotlin/collections/ArrayList;", "colors", "", "getColors", "()[I", "setColors", "([I)V", "completedPaint", "Landroid/text/TextPaint;", "completedText", "", "disableAnimateIndex", "endColor", "getEndColor", "setEndColor", "graphLeftAndRightPadding", "graphLeftPadding", "graphModelList", "Lcom/example/painthings/barchart/GraphModel;", "listGraphValues", "Lcom/justin/popupbarchart/GraphValue;", "mActionMoveModelIndex", "mAnimatedFraction", "mAnimationDuration", "mAnimatorListener", "Landroid/animation/Animator$AnimatorListener;", "mAnimatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mDayTextPaint", "mProgressAnimator", "Landroid/animation/ValueAnimator;", "mProgressBGPaint", "mProgressPaint", "mTodayTextPaint", "maxFraction", "minFraction", "padding", "paddingBetweenText", "pathTooltip2", "Landroid/graphics/Path;", "percentageBounds", "Landroid/graphics/Rect;", "percentagePaint", "percentageText", "", "roundCorner", "getRoundCorner", "()Z", "setRoundCorner", "(Z)V", "secondaryColor", "getSecondaryColor", "setSecondaryColor", "split", "startColor", "getStartColor", "setStartColor", "startingPoint", "tooltipAnchorBottomPoint", "tooltipBg", "getTooltipBg", "setTooltipBg", "tooltipBgPaint", "tooltipHeadRectWidth", "tooltipLeftPoint", "tooltipSubTitleTextColor", "getTooltipSubTitleTextColor", "setTooltipSubTitleTextColor", "tooltipSubTitleTextFontFamily", "getTooltipSubTitleTextFontFamily", "setTooltipSubTitleTextFontFamily", "tooltipSubTitleTextSize", "getTooltipSubTitleTextSize", "setTooltipSubTitleTextSize", "tooltipTitleTextColor", "getTooltipTitleTextColor", "setTooltipTitleTextColor", "tooltipTitleTextFontFamily", "getTooltipTitleTextFontFamily", "setTooltipTitleTextFontFamily", "tooltipTitleTextSize", "getTooltipTitleTextSize", "setTooltipTitleTextSize", "tooltipTopPoint", "topPoint", "totalBarCount", "widgetHeight", "widgetWidth", "animateProgress", "", "calculateDefaultTooltipSize", "calculateGraphValues", "width", "height", "calculateTooltipValuesV2", "xPoint", "yPoint", "drawCustomizeBarColor", "drawGraph", "canvas", "Landroid/graphics/Canvas;", "drawTooltip", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBarRoundCorner", "setBarSecondaryColor", "setCustomBarSize", "field", "setCustomizeBarSize", "setGraphValues", "graphValue", "", "setProgressBarFontFamily", "setProgressBarTextColor", "setProgressBarTextSize", "app_debug"})
public final class PopupBarChart extends android.view.View {
    private int widgetWidth = 0;
    private int widgetHeight = 0;
    private final float topPoint = 10.0F;
    private final float padding = 0.0F;
    private final float paddingBetweenText = 4.0F;
    private final java.lang.String completedText = "completed";
    private java.lang.String percentageText = "00%";
    private float tooltipAnchorBottomPoint = 0.0F;
    private final android.graphics.Rect percentageBounds = null;
    private float tooltipHeadRectWidth = 0.0F;
    private final android.graphics.Path pathTooltip2 = null;
    private float tooltipLeftPoint = 10.0F;
    private float tooltipTopPoint = 10.0F;
    private final float barWidth = 0.0F;
    private final float graphLeftAndRightPadding = 0.0F;
    private final float graphLeftPadding = 0.0F;
    private final int totalBarCount = 6;
    private int split = 0;
    private float startingPoint = 0.0F;
    private float barHeight = 0.0F;
    private java.util.ArrayList<com.example.painthings.barchart.GraphModel> graphModelList;
    private final java.util.ArrayList<com.justin.popupbarchart.GraphValue> listGraphValues = null;
    private final java.util.ArrayList<android.graphics.Paint> bgPaintList = null;
    @org.jetbrains.annotations.NotNull()
    private int[] colors;
    private final android.animation.ValueAnimator mProgressAnimator = null;
    private final android.animation.Animator.AnimatorListener mAnimatorListener = null;
    private final android.animation.ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = null;
    private final float maxFraction = 1.0F;
    private final float minFraction = 0.0F;
    private final int animateAllIndex = -2;
    private final int disableAnimateIndex = -1;
    private final int mAnimationDuration = 1000;
    private int mActionMoveModelIndex;
    private float mAnimatedFraction = 0.0F;
    private int endColor;
    private int startColor;
    private boolean roundCorner = true;
    private int secondaryColor = -1;
    private int barSize;
    private int barTextColor = -1;
    private int barTextFontFamily = -1;
    private int barTextSize;
    private int tooltipBg = -1;
    private int tooltipTitleTextColor = -1;
    private int tooltipSubTitleTextColor = -1;
    private int tooltipTitleTextFontFamily = -1;
    private int tooltipSubTitleTextFontFamily = -1;
    private int tooltipTitleTextSize;
    private int tooltipSubTitleTextSize;
    private final android.text.TextPaint mDayTextPaint = null;
    private final android.text.TextPaint mTodayTextPaint = null;
    private final android.graphics.Paint mProgressPaint = null;
    private final android.graphics.Paint mProgressBGPaint = null;
    private final android.text.TextPaint percentagePaint = null;
    private final android.text.TextPaint completedPaint = null;
    private final android.graphics.Paint tooltipBgPaint = null;
    
    @kotlin.jvm.JvmOverloads()
    public PopupBarChart(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PopupBarChart(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getColors() {
        return null;
    }
    
    public final void setColors(@org.jetbrains.annotations.NotNull()
    int[] p0) {
    }
    
    public final int getEndColor() {
        return 0;
    }
    
    public final void setEndColor(int p0) {
    }
    
    public final int getStartColor() {
        return 0;
    }
    
    public final void setStartColor(int p0) {
    }
    
    public final boolean getRoundCorner() {
        return false;
    }
    
    public final void setRoundCorner(boolean value) {
    }
    
    public final int getSecondaryColor() {
        return 0;
    }
    
    public final void setSecondaryColor(int value) {
    }
    
    public final int getBarSize() {
        return 0;
    }
    
    public final void setBarSize(int value) {
    }
    
    public final int getBarTextColor() {
        return 0;
    }
    
    public final void setBarTextColor(int value) {
    }
    
    public final int getBarTextFontFamily() {
        return 0;
    }
    
    public final void setBarTextFontFamily(int value) {
    }
    
    public final int getBarTextSize() {
        return 0;
    }
    
    public final void setBarTextSize(int value) {
    }
    
    public final int getTooltipBg() {
        return 0;
    }
    
    public final void setTooltipBg(int value) {
    }
    
    public final int getTooltipTitleTextColor() {
        return 0;
    }
    
    public final void setTooltipTitleTextColor(int value) {
    }
    
    public final int getTooltipSubTitleTextColor() {
        return 0;
    }
    
    public final void setTooltipSubTitleTextColor(int value) {
    }
    
    public final int getTooltipTitleTextFontFamily() {
        return 0;
    }
    
    public final void setTooltipTitleTextFontFamily(int value) {
    }
    
    public final int getTooltipSubTitleTextFontFamily() {
        return 0;
    }
    
    public final void setTooltipSubTitleTextFontFamily(int value) {
    }
    
    public final int getTooltipTitleTextSize() {
        return 0;
    }
    
    public final void setTooltipTitleTextSize(int value) {
    }
    
    public final int getTooltipSubTitleTextSize() {
        return 0;
    }
    
    public final void setTooltipSubTitleTextSize(int value) {
    }
    
    public final void setGraphValues(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justin.popupbarchart.GraphValue> graphValue) {
    }
    
    private final void setBarRoundCorner(boolean roundCorner) {
    }
    
    private final void setBarSecondaryColor(int secondaryColor) {
    }
    
    private final void setCustomBarSize(int field) {
    }
    
    private final void setProgressBarTextColor(int field) {
    }
    
    private final void setProgressBarFontFamily(int field) {
    }
    
    private final void setProgressBarTextSize(int field) {
    }
    
    public final void animateProgress() {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    private final void calculateGraphValues(int width, int height) {
    }
    
    private final void calculateDefaultTooltipSize(java.lang.String percentageText) {
    }
    
    private final void calculateTooltipValuesV2(java.lang.String percentageText, float xPoint, float yPoint) {
    }
    
    private final void drawTooltip(android.graphics.Canvas canvas) {
    }
    
    private final void drawGraph(android.graphics.Canvas canvas) {
    }
    
    private final java.util.ArrayList<android.graphics.Paint> drawCustomizeBarColor() {
        return null;
    }
    
    private final void setCustomizeBarSize(int field) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas canvas) {
    }
}