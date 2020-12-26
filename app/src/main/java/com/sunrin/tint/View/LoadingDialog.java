package com.sunrin.tint.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.sunrin.tint.R;

public class LoadingDialog extends Dialog {

    private Context context;
    private LottieAnimationView animView;
    private TextView loadingText;

    public LoadingDialog(@NonNull Context context) {
        super(context);
        super.setCancelable(false);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);

        animView = findViewById(R.id.lottieAnimation);
        loadingText = findViewById(R.id.loading_text);

        animView.setAnimation(R.raw.loading);
        animView.setRepeatCount(LottieDrawable.INFINITE);
        animView.playAnimation();
    }

    public LoadingDialog setMessage(String s) {
        if (loadingText != null)
            loadingText.setText(s);
        return this;
    }

    public void finish(boolean isSuccess) {
        if (animView != null) {
            animView.pauseAnimation();
            animView.setVisibility(View.GONE);
        }

        if (isSuccess)
            new Handler(Looper.getMainLooper()).postDelayed(this::cancel, 1500);
        else
            loadingText.setTextColor(ContextCompat.getColor(context, R.color.pink_200));

        setCancelable(true);
    }
}