package ua.com.mcsim.fingerpainting;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, View.OnTouchListener {


    private DrawView drawView;
    private View mContentView;
    private FrameLayout frame;
    private TextView letter;
    private ExpandableListView elvMain;
    private DrawerLayout drawer;
    private final String CLEAR = "";
    private String lastLetter = CLEAR;
    private ImageButton btnErase, btnLetter, btnPalette;
    private boolean isLetterShowed = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        orientationLocking();

        //***********Fullscreen with action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        btnErase = (ImageButton) findViewById(R.id.btn_erase);
        btnErase.setOnClickListener(this);
        btnLetter = (ImageButton) findViewById(R.id.btn_letter);
        btnLetter.setOnClickListener(this);
        btnPalette = (ImageButton) findViewById(R.id.btn_palette);
        btnPalette.setOnClickListener(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Create frame with draw screen
        frame = (FrameLayout) findViewById(R.id.frame);
        drawView = new DrawView(this);
        frame.addView(drawView);
        letter = (TextView) findViewById(R.id.letter);
        letter.setText("A");

        //Create expandable List View
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, drawView, drawer, frame, letter);

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);

    }

    private void orientationLocking() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

    private void showhideLetter() {

        if (!letter.getText().toString().equals(CLEAR)) {
            lastLetter = letter.getText().toString();
            letter.setText(CLEAR);
            btnLetter.setBackgroundDrawable(getResources().getDrawable(R.drawable.letters_40x40));
        } else {
            letter.setText(lastLetter);
            btnLetter.setBackgroundDrawable(getResources().getDrawable(R.drawable.letters2_40x40));
        }
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            AlertDialog.Builder alertDialog= new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle(R.string.dialog_title);
            alertDialog.setMessage(R.string.about_message);
            alertDialog.setNegativeButton(R.string.dialog_button_ok, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_erase:{
                if (drawView!=null) {
                    drawView.clearPoints();
                }
                break;
            }
            case R.id.btn_letter:{
                showhideLetter();
                break;
            }
            case R.id.btn_palette:{
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
            }
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
