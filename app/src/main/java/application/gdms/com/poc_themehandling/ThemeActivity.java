package application.gdms.com.poc_themehandling;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

public class ThemeActivity extends AppCompatActivity {

    public static final String INDIGO = "indigo";
    public static final String PINK = "pink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getSavedTheme());
        setContentView(R.layout.activity_theme);

        TextView themeName = findViewById(R.id.testTextViewTheme);
        themeName.setText(getSavedTheme() == R.style.AppTheme_NoActionBar_Indigo ? "Indigo" : "Pink");

        Button btnGreen = findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTheme(INDIGO);
            }
        });

        Button btnBlue = findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTheme(PINK);
            }
        });

        SwitchCompat switchCompat = findViewById(R.id.switchView);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    saveTheme(INDIGO);
                } else {
                    saveTheme(PINK);
                }
            }
        });
    }

    private void saveTheme(String value) {
        SharedPreferences.Editor editor = getPreferences(Activity.MODE_PRIVATE).edit();
        editor.putString("theme", value);
        editor.commit();
        recreate();
    }

    private int getSavedTheme() {
        String theme = getPreferences(Activity.MODE_PRIVATE).getString("theme", INDIGO);
        switch (theme) {
            case PINK:
                return R.style.AppTheme_NoActionBar_Pink;
            case INDIGO:
            default:
                return R.style.AppTheme_NoActionBar_Indigo;
        }
    }
}
