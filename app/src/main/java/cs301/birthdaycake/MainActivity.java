package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private CakeView cake;
    private View blowOut;
    private CompoundButton candles;
    private SeekBar candleNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        cake = findViewById(R.id.cakeview);
        CakeController newCake = new CakeController(cake);

        blowOut = findViewById(R.id.blowOutButton);
        blowOut.setOnClickListener(newCake);

        candles = findViewById(R.id.candles);
        candles.setOnCheckedChangeListener(newCake);

        candleNum = findViewById(R.id.candleAmount);
        candleNum.setOnSeekBarChangeListener(newCake);
    }

    public void goodbye(View Button) {
        Log.i("goodbyeButton","Goodbye");
    }
}
