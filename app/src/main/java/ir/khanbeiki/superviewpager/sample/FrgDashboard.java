package ir.khanbeiki.superviewpager.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;



import ir.khanbeiki.superviewpager.SuperViewPagerListener;

public class FrgDashboard extends Fragment implements SuperViewPagerListener {

    private View rootView;
    private Context context;
    private Activity activity;

    @Override
    public void onFragmentCommandDo() {
        runView();
    }

    @Override
    public void onFragmentAlwaysDo() {
        alwaysRunView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        this.activity = getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
        activity = null;
    }

    private void alwaysRunView() {

    }
    private void runView() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_dashboard, container, false);
    }

}