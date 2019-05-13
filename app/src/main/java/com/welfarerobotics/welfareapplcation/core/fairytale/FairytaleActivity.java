package com.welfarerobotics.welfareapplcation.core.fairytale;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.welfarerobotics.welfareapplcation.R;
import com.welfarerobotics.welfareapplcation.api.chat.chatutil.Fairytale;
import com.welfarerobotics.welfareapplcation.core.BaseActivity;

public class FairytaleActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//액티비티를 다이얼로그 형식으로 표시
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fairytale);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.0f; //메인액티비티 투명도 조절
        layoutParams.alpha = 0.0f;
        getWindow().setAttributes(layoutParams);
        Fairytale.get().play();

        Display dp = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (dp.getWidth() * 1.0);
        int height = (int) (dp.getHeight() * 1.0);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Fairytale.get().stop();
                finish();
                break;
            case MotionEvent.ACTION_UP:    //화면을 터치했다 땠을때
                break;
            case MotionEvent.ACTION_MOVE:    //화면을 터치하고 이동할때
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}