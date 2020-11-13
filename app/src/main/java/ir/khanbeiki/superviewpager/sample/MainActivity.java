package ir.khanbeiki.superviewpager.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import ir.khanbeiki.superviewpager.SuperAdapter;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;

public class MainActivity extends AppCompatActivity {

    private PageNavigationView pageNavigationView;
    private NavigationController navigationControllerOne;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageNavigationView = findViewById(R.id.pageNavigationView);
        viewPager = findViewById(R.id.viewPager);

        SuperAdapter adapter = new SuperAdapter(getSupportFragmentManager(), 0);
        adapter.addFragment(0, true, new FrgDashboard("Dashboard"), "0");
        adapter.addFragment(1, false, new FrgDashboard("LessonMap"), "1");
        adapter.addFragment(2, 1, new FrgDashboard("LeaderBoard"), "2");
        adapter.addFragment(3, 5, new FrgDashboard("Analyze"), "3");

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