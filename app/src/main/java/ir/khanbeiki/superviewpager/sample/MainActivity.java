package ir.khanbeiki.superviewpager.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import ir.khanbeiki.superviewpager.TabAdapter;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;

public class MainActivity extends AppCompatActivity {

    private  PageNavigationView pageNavigationView;
    private NavigationController navigationControllerOne;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageNavigationView = findViewById(R.id.pageNavigationView);
        viewPager = findViewById(R.id.viewPager);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), 0);
        adapter.addFragment(0, true, new FrgDashboard(), "0");
        adapter.addFragment(1, true, new FrgDashboard(), "1");
        adapter.addFragment(2, true, new FrgDashboard(), "2");
        adapter.addFragment(3, true, new FrgDashboard(), "3");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);

        navigationControllerOne = pageNavigationView.custom()
                .addItem(newItem(R.drawable.ic_main_tab_defalt_0, R.drawable.ic_main_tab_check_0, "Dashboard"))
                .addItem(newItem(R.drawable.ic_main_tab_defalt_1, R.drawable.ic_main_tab_check_1, "LessonMap"))
                .addItem(newItem(R.drawable.ic_main_tab_defalt_2, R.drawable.ic_main_tab_check_2, "LeaderBoard"))
                .addItem(newItem(R.drawable.ic_main_tab_defalt_3, R.drawable.ic_main_tab_check_3, "Analyze"))
                .build();
        navigationControllerOne.setupWithViewPager(viewPager);
        adapter.setViewPager(viewPager);
    }
    private BaseTabItem newItem(int drawable, int checkedDrawable, String title) {
        OnlyIconItemView mainTab = new OnlyIconItemView(this);
        mainTab.initialize(drawable, checkedDrawable);
        mainTab.setTitle(title);
        return mainTab;
    }
}