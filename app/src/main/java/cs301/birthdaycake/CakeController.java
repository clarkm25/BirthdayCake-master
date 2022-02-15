package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private CakeView cakeV;
    private CakeModel cakeM;

    public CakeController(CakeView initCakeV) {
        cakeV = initCakeV;
        cakeM = cakeV.getCake();
    }

    @Override
    public void onClick(View v) {
        Log.d("blowOutButton","BlowOut");
        cakeM.candleLit = false;
        cakeV.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true) {
            cakeM.candles = true;
        }
        else {
            cakeM.candles = false;
        }
        cakeV.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cakeM.candleAmount = progress;
        cakeV.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //not needed
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //not needed
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        cakeM.xLocation = (float)event.getX();
        cakeM.yLocation = (float)event.getY();

        cakeV.invalidate();

        return true;
    }
}
