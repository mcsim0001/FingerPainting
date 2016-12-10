package ua.com.mcsim.fingerpainting;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by mcsim on 10.11.2016.
 */
public class Point {
    public final float x, y;
    public final int col;
    public final int width;

    public Point(final float x, final float y, final int col, final int width) {
        this.x = x;
        this.y = y;
        this.col = col;
        this.width = width;
    }

    public void draw(final Canvas canvas, final Paint paint) {
        paint.setColor(col);
        canvas.drawCircle(x, y, width/2, paint);
    }

    @Override
    public String toString() {
        return x + ", " + y + ", " + col;
    }
}
