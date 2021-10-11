package app.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mscore1,mscore2;
    TextView tv1,tv2;
    final String SCORE1="Team 1 score";
    final String SCORE2="Team 2 score";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.score1);
        tv2=findViewById(R.id.score2);
if (savedInstanceState!=null)
{
    mscore1=savedInstanceState.getInt(SCORE1);
    mscore2=savedInstanceState.getInt(SCORE2);

    tv1.setText(String.valueOf(mscore1));
    tv2.setText(String.valueOf(mscore2));
}
    }



    public void decreaseScore(View view)
    {
        int ViewId=view.getId();
        switch (ViewId)
        {
            case R.id.decreaseTeam1:
                mscore1--;
                tv1.setText(String.valueOf(mscore1));
                break;
            case R.id.decreaseTeam2:
                mscore2--;
                tv2.setText(String.valueOf(mscore2));
                break;
        }
    }
    public void increaseScore(View view)
    {
        int ViewId=view.getId();
        switch (ViewId)
        {
            case R.id.increaseTeam1:
                mscore1++;
                tv1.setText(String.valueOf(mscore1));
                break;
            case R.id.increaseTeam2:
                mscore2++;
                tv2.setText(String.valueOf(mscore2));
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        int nightMode=AppCompatDelegate.getDefaultNightMode();
        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES)
        {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else
        {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.night_mode)
        {
            int nightMode= AppCompatDelegate.getDefaultNightMode();
            if(nightMode==AppCompatDelegate.MODE_NIGHT_YES)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }


        return true;
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SCORE1,mscore1);
        outState.putInt(SCORE2,mscore2);
        super.onSaveInstanceState(outState);
    }
}