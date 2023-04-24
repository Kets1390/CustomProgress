package com.custom_progress;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;


public class CustomProgressView extends LinearLayout {

    private static final int DEFAULT_PROGRESS_COLOR = Color.BLUE;
    private static final int DEFAULT_SELECTED_COLOR = Color.GREEN;
    private static final int DEFAULT_NORMAL_COLOR = Color.GRAY;
    private static final int DEFAULT_PROGRESS = 5;
    private static final int DEFAULT_CURRENT_PROGRESS = 0;


    public int Total_progress = DEFAULT_PROGRESS;
    public int Current_progress = DEFAULT_CURRENT_PROGRESS;
    public int progress_color = DEFAULT_PROGRESS_COLOR;
    public int normal_color = DEFAULT_NORMAL_COLOR;
    public int selected_color = DEFAULT_SELECTED_COLOR;
    private int height;
    private int width;
    private int Space;
    private int ViewHeight;
    private boolean isCompleted;
    public  CustomProgressView(Context context){
        super(context);
        if(Space == 0){
            Space = context.getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._2sdp);
        }
        SetData(context);
    }
    public CustomProgressView(Context context,  AttributeSet attrs) {
        this(context,attrs,0);

    }
    public CustomProgressView(Context context,  AttributeSet attrs,int defStyle){
        super(context, attrs, defStyle);
      //  DisplayMetrics displayMetrics = new DisplayMetrics();
//        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        height = displayMetrics.heightPixels;
//        width = displayMetrics.widthPixels;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressView,0,0);
        try {
            Total_progress = a.getInt(R.styleable.CustomProgressView_total_progress,5);
            Current_progress = a.getInt(R.styleable.CustomProgressView_current_progress, 0);
            progress_color = a.getColor(R.styleable.CustomProgressView_progress_color,DEFAULT_PROGRESS_COLOR);
            //progress_color = a.getColorStateList(R.styleable.CustomProgressView_progress_color);
            normal_color = a.getColor(R.styleable.CustomProgressView_normal_color, DEFAULT_NORMAL_COLOR);
//            normal_color = a.getColorStateList(R.styleable.CustomProgressView_normal_color);
//            selected_color = a.getColorStateList(R.styleable.CustomProgressView_selected_color);
            selected_color = a.getColor(R.styleable.CustomProgressView_selected_color, DEFAULT_SELECTED_COLOR);
            Space = (int) a.getDimensionPixelOffset(R.styleable.CustomProgressView_space,context.getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._2sdp));
            ViewHeight = a.getDimensionPixelOffset(R.styleable.CustomProgressView_height, context.getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._15sdp));
            isCompleted = a.getBoolean(R.styleable.CustomProgressView_progress_complete, false);
            SetData(context);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            a.recycle();
        }
    }

    public void SetData(Context context){
        if(Total_progress > 0){
            removeAllViews();

            if(ViewHeight == 0){
                ViewHeight = context.getResources().getDimensionPixelOffset(com.intuit.sdp.R.dimen._15sdp);
            }
            LayoutParams mainParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT, Total_progress);

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(mainParams);
            for(int i=0;i<Total_progress;i++){
                View childView = new View(context);
                //LayoutParams params = new LayoutParams((width/Total_progress),ViewHeight);
                LayoutParams params = new LayoutParams(0,ViewHeight);
                params.setMargins(Space,0,Space,0);
                params.weight=1;
                childView.setLayoutParams(params);
                if(isCompleted)
                {
                    childView.setBackgroundColor(progress_color);
                }
                else {
                    if ((Current_progress - 1) > i) {
                        childView.setBackgroundColor(progress_color);
                    } else if (i == (Current_progress - 1)) {
                        childView.setBackgroundColor(selected_color);
                    } else {
                        childView.setBackgroundColor(normal_color);
                    }
                }
                linearLayout.addView(childView);
            }
            addView(linearLayout);

        }
    }
public void setTotal_progress(Context context,int total_progress, int current_progress){
        this.Total_progress = total_progress;
        this.Current_progress = current_progress;
    invalidate();
    requestLayout();
    SetData(context);
}
public void setCurrent_progress(Context context, int current_progress){
        this.Current_progress =current_progress;

        if(Current_progress > Total_progress){
            isCompleted = true;
        }
        else
        {
            isCompleted = false;
        }
        invalidate();
        requestLayout();
        SetData(context);
}
public void isProgressCompleted( Context context, boolean isComplete){
        this.isCompleted = isComplete;
    invalidate();
    requestLayout();
    SetData(context);
}
}
