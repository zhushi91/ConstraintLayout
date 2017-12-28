package com.geometry.constraintlayout.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;

public class CharterYLabels extends CharterLabelsBase {
  public CharterYLabels(Context context) {
    this(context, null);
  }

  public CharterYLabels(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CharterYLabels(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public CharterYLabels(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override public void draw(Canvas canvas) {
    super.draw(canvas);

    if (values == null || values.length == 0) {
      return;
    }

    final int valuesLength = values.length;

    final float height = getMeasuredHeight();
    final float width = getMeasuredWidth();

    final float gap = height / (valuesLength - 1);

    int visibilityPatternPos = -1;
    float x;
    float y;

    for (int i = 0; i < valuesLength; i++) {
      String value = allCaps ? values[i].toUpperCase() : values[i];

      if (visibilityPatternPos + 1 >= visibilityPattern.length) {
        visibilityPatternPos = 0;
      } else {
        visibilityPatternPos++;
      }

      if (visibilityPattern[visibilityPatternPos]) {
        Rect textBounds = new Rect();
        paintLabel.getTextBounds(value, 0, value.length(), textBounds);
        int textHeight = 2 * textBounds.bottom - textBounds.top;
        float textWidth = textBounds.right;

        switch (horizontalGravity) {
          default:
            // HORIZONTAL_GRAVITY_LEFT
            x = 0;
            break;

          case HORIZONTAL_GRAVITY_CENTER:
            x = (width - textWidth) / 2;
            break;

          case HORIZONTAL_GRAVITY_RIGHT:
            x = width - textWidth;
            break;
        }

        if (i == 0) {
          y = height;
        } else if (i == valuesLength - 1) {
          y = textHeight;
        } else {
          y = gap * i + (textHeight / 2);
        }
        canvas.drawText(value, x, y, paintLabel);
      }
    }
  }
}
