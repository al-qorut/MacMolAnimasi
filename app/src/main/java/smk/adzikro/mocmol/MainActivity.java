package smk.adzikro.mocmol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WhackAMoleView whackAMoleView;
    private static final int TOGGLE_SOUND =1;
    private boolean soundEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        whackAMoleView = (WhackAMoleView)findViewById(R.id.game);
        whackAMoleView.setKeepScreenOn(true);
    }

    public boolean oncreateOptionsMenu(Menu menu){
        MenuItem toggleSound = menu.add(0, TOGGLE_SOUND, 0,"Toggle Sound");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case TOGGLE_SOUND:
                String soundEnabledText = "Sound on";
                if(soundEnabled){
                    soundEnabled = false;
                    soundEnabledText = "Sound off";
                }else{
                    soundEnabled = true;
                }
                Toast.makeText(this,soundEnabledText,Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
