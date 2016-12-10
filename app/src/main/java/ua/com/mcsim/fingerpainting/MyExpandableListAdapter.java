package ua.com.mcsim.fingerpainting;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout;


public class MyExpandableListAdapter extends BaseExpandableListAdapter implements View.OnClickListener{

    private TextView tv_1 ,tv_2 ,tv_3 ,tv_4 ,tv_5 ,tv_6 ,tv_7 ,tv_8 ,tv_9 ,tv_10 ,tv_11 ,tv_12 ,
            tv_13 ,tv_14 ,tv_15 ,tv_16 ,tv_17 ,tv_18 ,tv_19 ,tv_20 ,tv_21 ,tv_22 ,tv_23 ,
            tv_24 ,tv_25 ,tv_26 ,tv_27 ,tv_28 ,tv_29 ,tv_30 ,tv_31 ,tv_32 ,tv_33 ,tv_34 ,tv_35;
    private LayoutInflater mInflater;
    private Context ctx;
    private DrawView drawView;
    private android.support.v4.widget.DrawerLayout drawer;
    private FrameLayout frame;
    private TextView letter;
    private SeekBar sbSize;
    private int seekProg = 10;


    //Constructors
    public MyExpandableListAdapter(Context context,
                                   DrawView drawView,
                                   DrawerLayout drawer,
                                   FrameLayout frame,
                                   TextView letter)
    {
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.ctx = context;
        this.drawView = drawView;
        this.drawer = drawer;
        this.frame = frame;
        this.letter = letter;

    }


    @Override
    public int getGroupCount() {
        return 4;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.group_name, parent, false);
        TextView tv = (TextView) convertView.findViewById(R.id.text1);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image1);
        if (groupPosition == 0) {
            tv.setText(R.string.brush_size);
            imageView.setImageResource(R.drawable.brush60x60);
            return convertView;}
        if (groupPosition == 1) {
            tv.setText(R.string.brush_color);
            imageView.setImageResource(R.drawable.palette60x60);
            return convertView;}
        if (groupPosition == 2) {
            tv.setText(R.string.background);
            imageView.setImageResource(R.drawable.molbert60x60);
            return convertView;}
        else {
            tv.setText(R.string.letters);
            imageView.setImageResource(R.drawable.letters2_60x60);
            return convertView;}

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        convertView = newChildView(parent, groupPosition);
        bindChildView(convertView,groupPosition);

        return convertView;

    }

    private View newChildView(ViewGroup parent, int groupPosition) {
        if (groupPosition == 0) {
            return mInflater.inflate(R.layout.group0_item, parent, false);}
        if (groupPosition == 1) {
            return mInflater.inflate(R.layout.group1_item, parent, false);}
        if (groupPosition == 2) {
            return mInflater.inflate(R.layout.group2_item, parent, false);}
        if (groupPosition == 3) {
            return mInflater.inflate(R.layout.group3_item, parent, false);}
        else return null;
    }

    private void bindChildView(View v, int groupPosition) {
        ImageButton ibWhite,ibBlack,ibRed,ibBlue,ibLBlue,ibYellow,ibPurple, ibGreen,ibOrange,
                ibBgDefault1,ibBgDefault2,ibBgDefault3,ibBgWhite,ibBgBlack,ibBgRed,ibBgBlue,
                ibBgLBlue,ibBgYellow,ibBgPurple, ibBgGreen,ibBgOrange;



        if (v!= null) {
            if (groupPosition == 0) {
                //Seekbar for brush size
                sbSize = (SeekBar) v.findViewById(R.id.seekBar);
                sbSize.setProgress(seekProg);
                sbSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    int prog;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        prog=progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        drawView.changeWidth(prog);
                        seekProg = prog;
                    }
                });

            }
            if (groupPosition == 1) {
                //Palette buttons
                ibWhite = (ImageButton) v.findViewById(R.id.ib_white);
                ibWhite.setOnClickListener(this);
                ibBlack = (ImageButton) v.findViewById(R.id.ib_black);
                ibBlack.setOnClickListener(this);
                ibRed = (ImageButton) v.findViewById(R.id.ib_red);
                ibRed.setOnClickListener(this);
                ibBlue = (ImageButton) v.findViewById(R.id.ib_dark_blue);
                ibBlue.setOnClickListener(this);
                ibLBlue = (ImageButton) v.findViewById(R.id.ib_light_blue);
                ibLBlue.setOnClickListener(this);
                ibYellow = (ImageButton) v.findViewById(R.id.ib_yellow);
                ibYellow.setOnClickListener(this);
                ibPurple = (ImageButton) v.findViewById(R.id.ib_purple);
                ibPurple.setOnClickListener(this);
                ibGreen = (ImageButton) v.findViewById(R.id.ib_green);
                ibGreen.setOnClickListener(this);
                ibOrange = (ImageButton) v.findViewById(R.id.ib_orange);
                ibOrange.setOnClickListener(this);

            }
            if (groupPosition == 2) {
                //Background palette
                ibBgWhite = (ImageButton) v.findViewById(R.id.ib_bg_white);
                ibBgWhite.setOnClickListener(this);
                ibBgBlack = (ImageButton) v.findViewById(R.id.ib_bg_black);
                ibBgBlack.setOnClickListener(this);
                ibBgRed = (ImageButton) v.findViewById(R.id.ib_bg_red);
                ibBgRed.setOnClickListener(this);
                ibBgBlue = (ImageButton) v.findViewById(R.id.ib_bg_dark_blue);
                ibBgBlue.setOnClickListener(this);
                ibBgLBlue = (ImageButton) v.findViewById(R.id.ib_bg_light_blue);
                ibBgLBlue.setOnClickListener(this);
                ibBgYellow = (ImageButton) v.findViewById(R.id.ib_bg_yellow);
                ibBgYellow.setOnClickListener(this);
                ibBgPurple = (ImageButton) v.findViewById(R.id.ib_bg_purple);
                ibBgPurple.setOnClickListener(this);
                ibBgGreen = (ImageButton) v.findViewById(R.id.ib_bg_green);
                ibBgGreen.setOnClickListener(this);
                ibBgOrange = (ImageButton) v.findViewById(R.id.ib_bg_orange);
                ibBgOrange.setOnClickListener(this);
                ibBgDefault1 = (ImageButton) v.findViewById(R.id.ib_bg_picture1);
                ibBgDefault1.setOnClickListener(this);
                ibBgDefault2 = (ImageButton) v.findViewById(R.id.ib_bg_picture2);
                ibBgDefault2.setOnClickListener(this);
                ibBgDefault3 = (ImageButton) v.findViewById(R.id.ib_bg_picture3);
                ibBgDefault3.setOnClickListener(this);
            }
            if (groupPosition == 3) {
                //Letters
                tv_1 = (TextView) v.findViewById(R.id.l1); tv_1.setOnClickListener(this);
                tv_2 = (TextView) v.findViewById(R.id.l2); tv_2.setOnClickListener(this);
                tv_3 = (TextView) v.findViewById(R.id.l3); tv_3.setOnClickListener(this);
                tv_4 = (TextView) v.findViewById(R.id.l4); tv_4.setOnClickListener(this);
                tv_5 = (TextView) v.findViewById(R.id.l5); tv_5.setOnClickListener(this);
                tv_6 = (TextView) v.findViewById(R.id.l6); tv_6.setOnClickListener(this);
                tv_7 = (TextView) v.findViewById(R.id.l7); tv_7.setOnClickListener(this);
                tv_8 = (TextView) v.findViewById(R.id.l8); tv_8.setOnClickListener(this);
                tv_9 = (TextView) v.findViewById(R.id.l9); tv_9.setOnClickListener(this);
                tv_10 = (TextView) v.findViewById(R.id.l10); tv_10.setOnClickListener(this);
                tv_11 = (TextView) v.findViewById(R.id.l11); tv_11.setOnClickListener(this);
                tv_12 = (TextView) v.findViewById(R.id.l12); tv_12.setOnClickListener(this);
                tv_13 = (TextView) v.findViewById(R.id.l13); tv_13.setOnClickListener(this);
                tv_14 = (TextView) v.findViewById(R.id.l14); tv_14.setOnClickListener(this);
                tv_15 = (TextView) v.findViewById(R.id.l15); tv_15.setOnClickListener(this);
                tv_16 = (TextView) v.findViewById(R.id.l16); tv_16.setOnClickListener(this);
                tv_17 = (TextView) v.findViewById(R.id.l17); tv_17.setOnClickListener(this);
                tv_18 = (TextView) v.findViewById(R.id.l18); tv_18.setOnClickListener(this);
                tv_19 = (TextView) v.findViewById(R.id.l19); tv_19.setOnClickListener(this);
                tv_20 = (TextView) v.findViewById(R.id.l20); tv_20.setOnClickListener(this);
                tv_21 = (TextView) v.findViewById(R.id.l21); tv_21.setOnClickListener(this);
                tv_22 = (TextView) v.findViewById(R.id.l22); tv_22.setOnClickListener(this);
                tv_23 = (TextView) v.findViewById(R.id.l23); tv_23.setOnClickListener(this);
                tv_24 = (TextView) v.findViewById(R.id.l24); tv_24.setOnClickListener(this);
                tv_25 = (TextView) v.findViewById(R.id.l25); tv_25.setOnClickListener(this);
                tv_26 = (TextView) v.findViewById(R.id.l26); tv_26.setOnClickListener(this);
                tv_27 = (TextView) v.findViewById(R.id.l27); tv_27.setOnClickListener(this);
                tv_28 = (TextView) v.findViewById(R.id.l28); tv_28.setOnClickListener(this);
                tv_29 = (TextView) v.findViewById(R.id.l29); tv_29.setOnClickListener(this);
                tv_30 = (TextView) v.findViewById(R.id.l30); tv_30.setOnClickListener(this);
                tv_31 = (TextView) v.findViewById(R.id.l31); tv_31.setOnClickListener(this);
                tv_32 = (TextView) v.findViewById(R.id.l32); tv_32.setOnClickListener(this);
                tv_33 = (TextView) v.findViewById(R.id.l33); tv_33.setOnClickListener(this);
                tv_34 = (TextView) v.findViewById(R.id.l34); tv_34.setOnClickListener(this);
                tv_35 = (TextView) v.findViewById(R.id.l35); tv_35.setOnClickListener(this);

            }
        } else {
            Toast.makeText(ctx, "Error. Item not binded.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_white: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.white));
                break;
            }
            case R.id.ib_black: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.black));
                break;
            }
            case R.id.ib_dark_blue: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.dark_blue));
                break;
            }
            case R.id.ib_light_blue: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.light_blue));
                break;
            }
            case R.id.ib_green: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.green));
                break;
            }
            case R.id.ib_orange: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.orange));
                break;
            }
            case R.id.ib_red: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.red));
                break;
            }
            case R.id.ib_yellow: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.yellow));
                break;
            }
            case R.id.ib_purple: {
                drawView.changeColour(ContextCompat.getColor(ctx, R.color.purple));
                break;
            }
            //Background palette
            case R.id.ib_bg_white: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.white));
                break;
            }
            case R.id.ib_bg_dark_blue: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.dark_blue));
                break;
            }
            case R.id.ib_bg_light_blue: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.light_blue));
                break;
            }
            case R.id.ib_bg_green: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.green));
                break;
            }
            case R.id.ib_bg_orange: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.orange));
                break;
            }
            case R.id.ib_bg_red: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.red));
                break;
            }
            case R.id.ib_bg_yellow: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.yellow));
                break;
            }
            case R.id.ib_bg_black: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.black));
                break;
            }
            case R.id.ib_bg_purple: {
                frame.setBackgroundColor(ContextCompat.getColor(ctx, R.color.purple));
                break;
            }
            case R.id.ib_bg_picture1: {
                frame.setBackgroundResource(R.drawable.schoolboard1280x800);
                break;
            }
            case R.id.ib_bg_picture2: {
                frame.setBackgroundResource(R.drawable.final_full1280x800);
                break;
            }
            case R.id.ib_bg_picture3: {
                frame.setBackgroundResource(R.drawable.recycled_texture1280x800);
                break;
            }

            //Letters
            case R.id.l1: {letter.setText(tv_1.getText().toString()); break;}
            case R.id.l2: {letter.setText(tv_2.getText().toString()); break;}
            case R.id.l3: {letter.setText(tv_3.getText().toString()); break;}
            case R.id.l4: {letter.setText(tv_4.getText().toString()); break;}
            case R.id.l5: {letter.setText(tv_5.getText().toString()); break;}
            case R.id.l6: {letter.setText(tv_6.getText().toString()); break;}
            case R.id.l7: {letter.setText(tv_7.getText().toString()); break;}
            case R.id.l8: {letter.setText(tv_8.getText().toString()); break;}
            case R.id.l9: {letter.setText(tv_9.getText().toString()); break;}
            case R.id.l10: {letter.setText(tv_10.getText().toString()); break;}
            case R.id.l11: {letter.setText(tv_11.getText().toString()); break;}
            case R.id.l12: {letter.setText(tv_12.getText().toString()); break;}
            case R.id.l13: {letter.setText(tv_13.getText().toString()); break;}
            case R.id.l14: {letter.setText(tv_14.getText().toString()); break;}
            case R.id.l15: {letter.setText(tv_15.getText().toString()); break;}
            case R.id.l16: {letter.setText(tv_16.getText().toString()); break;}
            case R.id.l17: {letter.setText(tv_17.getText().toString()); break;}
            case R.id.l18: {letter.setText(tv_18.getText().toString()); break;}
            case R.id.l19: {letter.setText(tv_19.getText().toString()); break;}
            case R.id.l20: {letter.setText(tv_20.getText().toString()); break;}
            case R.id.l21: {letter.setText(tv_21.getText().toString()); break;}
            case R.id.l22: {letter.setText(tv_22.getText().toString()); break;}
            case R.id.l23: {letter.setText(tv_23.getText().toString()); break;}
            case R.id.l24: {letter.setText(tv_24.getText().toString()); break;}
            case R.id.l25: {letter.setText(tv_25.getText().toString()); break;}
            case R.id.l26: {letter.setText(tv_26.getText().toString()); break;}
            case R.id.l27: {letter.setText(tv_27.getText().toString()); break;}
            case R.id.l28: {letter.setText(tv_28.getText().toString()); break;}
            case R.id.l29: {letter.setText(tv_29.getText().toString()); break;}
            case R.id.l30: {letter.setText(tv_30.getText().toString()); break;}
            case R.id.l31: {letter.setText(tv_31.getText().toString()); break;}
            case R.id.l32: {letter.setText(tv_32.getText().toString()); break;}
            case R.id.l33: {letter.setText(tv_33.getText().toString()); break;}
            case R.id.l34: {letter.setText(tv_34.getText().toString()); break;}
            case R.id.l35: {letter.setText(tv_35.getText().toString()); break;}

        }drawer.closeDrawer(GravityCompat.START);
    }
}
