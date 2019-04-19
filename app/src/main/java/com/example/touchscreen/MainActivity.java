package com.example.touchscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvInput = findViewById(R.id.tv_input);
        tvInput.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        TextView tvOutput = findViewById(R.id.tv_output);
        String actions[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL",
                "ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP" };
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        tvOutput.append(actions[actionCode]);
        tvOutput.append(" pointer index:" + pointerIndex);
        for (int i = 0; i < event.getPointerCount(); i++) {
            tvOutput.append(" pointer id:" + event.getPointerId(i) +
                    " x:" + event.getX(i) + " y:" + event.getY(i));
        }
        tvOutput.append("\n");
        return true;
    }
}
