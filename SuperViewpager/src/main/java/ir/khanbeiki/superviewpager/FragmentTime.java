package ir.khanbeiki.superviewpager;

import java.io.Serializable;

public class FragmentTime implements Serializable {
    private int id;
    private long runTime;
    private long minutes;
    private boolean isRun;
    private boolean isDisposable;

    public FragmentTime(int id, long minutes) {
        this.id = id;
        this.minutes = minutes;
    }

    public FragmentTime(int id, boolean isDisposable) {
        this.id = id;
        this.isDisposable = isDisposable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public boolean isDisposable() {
        return isDisposable;
    }

    public void setDisposable(boolean disposable) {
        isDisposable = disposable;
    }
}
