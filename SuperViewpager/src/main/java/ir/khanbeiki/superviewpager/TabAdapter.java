package ir.khanbeiki.superviewpager;

import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class TabAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private final SparseArray<WeakReference<Fragment>> instantiatedFragments = new SparseArray<>();
    private ArrayList<FragmentTime> ftList = new ArrayList<>();
    private ViewPager mViewPager;

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    // اگر isDisposable صحیح باشد فقط یکبار اجرا میشود
    public void addFragment(int id, boolean isDisposable, Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        ftList.add(new FragmentTime(id, isDisposable));
    }

    // اگر minutes صفر نباشد در اون تایم به دقیقه اجرا میشود
    // اگر minutes صفر باشد هر بار اجرا میشود
    public void addFragment(int id, long minutes, Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        ftList.add(new FragmentTime(id, minutes));
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(this);
    }

    private long getMinutesMillisecond(long minutes) {
        return minutes * 60 * 1000;
    }

    private boolean getFragmentTimeOpened(int position) {
        for (FragmentTime fto : ftList) {
            if (fto.getId() == position) {
                if (fto.isDisposable()) {
                    if (!fto.isRun()) {
                        ftList.get(position).setRun(true);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (fto.getMinutes() == 0) {
                        return true;
                    }
                    if (fto.getRunTime() == 0) {
                        ftList.get(position).setRunTime(Calendar.getInstance().getTimeInMillis());
                        return true;
                    } else {
                        long time = Calendar.getInstance().getTimeInMillis() - fto.getRunTime();
                        if (time < getMinutesMillisecond(ftList.get(position).getMinutes())) {
                            return false;
                        } else {
                            ftList.get(position).setRunTime(Calendar.getInstance().getTimeInMillis());
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final Fragment fragment = (Fragment) super.instantiateItem(container, position);
        instantiatedFragments.put(position, new WeakReference<>(fragment));
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        instantiatedFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Nullable
    Fragment getFragment(final int position) {
        final WeakReference<Fragment> wr = instantiatedFragments.get(position);
        if (wr != null) {
            return wr.get();
        } else {
            return null;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset == 0) {
            SuperViewPagerListener fragment = (SuperViewPagerListener) instantiateItem(mViewPager, position);
            if (getFragmentTimeOpened(position)) {
                fragment.onFragmentCommandDo();
            }
            fragment.onFragmentAlwaysDo();
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}