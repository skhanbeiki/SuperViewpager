package ir.khanbeiki.superviewpager.sample;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ir.khanbeiki.superviewpager.SuperViewPagerListener;

public class FrgDashboard extends Fragment implements SuperViewPagerListener {
    private ProgressBar prgCommandDo;
    private ProgressBar prgAlwaysDo;
    private TextView txtTitle;
    private String name;
    @Override
    public void onFragmentCommandDo() {
        total = 0;
        updateProgressBar(prgCommandDo);
    }

    @Override
    public void onFragmentAlwaysDo() {
        total = 0;
        updateProgressBar(prgAlwaysDo);
    }

    public FrgDashboard(String name) {
        this.name = name;
    }

    private int total;
    private Handler handler;
    private void updateProgressBar(final ProgressBar progressBar) {
        if (total < 100) {
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(total++);
                    updateProgressBar(progressBar);
                }
            }, 100);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prgCommandDo = view.findViewById(R.id.prgCommandDo);
        prgAlwaysDo = view.findViewById(R.id.prgAlwaysDo);
        txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(name);
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_dashboard, container, false);
    }
}

