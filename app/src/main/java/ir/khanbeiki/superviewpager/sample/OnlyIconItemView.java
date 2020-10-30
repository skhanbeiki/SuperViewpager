package ir.khanbeiki.superviewpager.sample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;


import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;

/**
 * 自定义一个只有图标的Item
 */
public class OnlyIconItemView extends BaseTabItem {

    private ImageView mIcon;
    private TextView txtTitle;

    private Drawable mDefaultDrawable;
    private Drawable mCheckedDrawable;

    private boolean mChecked;

    public OnlyIconItemView(Context context) {
        this(context, null);
    }

    public OnlyIconItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnlyIconItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.item_only_icon, this, true);
        mIcon = findViewById(R.id.icon);
        txtTitle = findViewById(R.id.txtTitle);

    }

    public void initialize(@DrawableRes int drawableRes, @DrawableRes int checkedDrawableRes) {
        mDefaultDrawable = ContextCompat.getDrawable(getContext(), drawableRes);
        mCheckedDrawable = ContextCompat.getDrawable(getContext(), checkedDrawableRes);
    }

    @Override
    public void setChecked(boolean checked) {
        mIcon.setImageDrawable(checked ? mCheckedDrawable : mDefaultDrawable);
        if (checked) {
            mIcon.setColorFilter(getContext().getResources().getColor(R.color.color_1));
            txtTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.color_1));
        } else {
            mIcon.setColorFilter(getContext().getResources().getColor(R.color.color_8));
            txtTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.color_8));
        }
        mChecked = checked;
    }

    @Override
    public void setMessageNumber(int number) {
        //不需要就不用管
    }

    @Override
    public void setHasMessage(boolean hasMessage) {
        //不需要就不用管
    }

    @Override
    public void setTitle(String title) {
        //不需要就不用管
        txtTitle.setText(title);
    }

    @Override
    public void setDefaultDrawable(Drawable drawable) {
        mDefaultDrawable = drawable;
        if (!mChecked) {
            mIcon.setImageDrawable(drawable);
        }
    }

    @Override
    public void setSelectedDrawable(Drawable drawable) {
        mCheckedDrawable = drawable;
        if (mChecked) {
            mIcon.setImageDrawable(drawable);
        }
    }

    @Override
    public void onRepeat() {
        super.onRepeat();
    }

    @Override
    public String getTitle() {
        return "no title";
    }
}
