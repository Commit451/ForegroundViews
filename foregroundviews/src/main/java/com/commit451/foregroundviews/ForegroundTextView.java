/*
 * ******************************************************************************
 *   Copyright (c)
 *   https://gist.github.com/chrisbanes/9091754
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */

package com.commit451.foregroundviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class ForegroundTextView extends AppCompatTextView {

    private ForegroundDelegate mForegroundDelegate;

    public ForegroundTextView(Context context) {
        this(context, null);
    }

    public ForegroundTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public ForegroundTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M || context.getApplicationInfo().targetSdkVersion < Build.VERSION_CODES.M) {
            mForegroundDelegate = new ForegroundDelegate(this);
            mForegroundDelegate.init(context, attrs, defStyleAttr, 0);
        }
    }

    @Override
    public int getForegroundGravity() {
        if (mForegroundDelegate != null) {
            return mForegroundDelegate.getForegroundGravity();
        } else {
            return super.getForegroundGravity();
        }
    }

    @Override
    public void setForegroundGravity(int foregroundGravity) {
        if (mForegroundDelegate != null) {
            mForegroundDelegate.setForegroundGravity(foregroundGravity);
        } else {
            super.setForegroundGravity(foregroundGravity);
        }
    }

    @Override
    protected boolean verifyDrawable(@NonNull Drawable who) {
        if (mForegroundDelegate != null) {
            return super.verifyDrawable(who) || (who == mForegroundDelegate.getForeground());
        } else {
            return super.verifyDrawable(who);
        }
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mForegroundDelegate != null) {
            mForegroundDelegate.jumpDrawablesToCurrentState();
        }
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mForegroundDelegate != null) {
            mForegroundDelegate.drawableStateChanged();
        }
    }

    @Override
    public void setForeground(Drawable foreground) {
        if (mForegroundDelegate != null) {
            mForegroundDelegate.setForeground(foreground);
        } else {
            super.setForeground(foreground);
        }
    }

    @Override
    public Drawable getForeground() {
        if (mForegroundDelegate != null) {
            return mForegroundDelegate.getForeground();
        } else {
            return super.getForeground();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mForegroundDelegate != null) {
            mForegroundDelegate.onLayout(changed, left, top, right, bottom);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mForegroundDelegate != null) {
            mForegroundDelegate.onSizeChanged(w, h, oldw, oldh);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (mForegroundDelegate != null) {
            mForegroundDelegate.draw(canvas);
        }
    }

    @Override
    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        if (mForegroundDelegate != null) {
            mForegroundDelegate.drawableHotspotChanged(x, y);
        }
    }
}
