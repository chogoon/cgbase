package com.chogoon.cglib;

import android.app.Application;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class BaseViewModel extends AndroidViewModel {

    public final SingleLiveEvent<Throwable> error = new SingleLiveEvent<>();
    public final MutableLiveData<Boolean> done = new MutableLiveData<>();

    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> left_title = new ObservableField<>("");
    public final ObservableField<String> right_title = new ObservableField<>("");
    public final ObservableBoolean loading = new ObservableBoolean(false);

    public final CheckLiveData<Boolean> complete_check = new CheckLiveData<>();
    public final MutableLiveData<Boolean> no_data = new MutableLiveData<>();

    public BaseViewModel(Application application) {
        super(application);
        loading.set(false);
    }

    protected void onError(Throwable throwable) {
        if (BuildConfig.DEBUG) throwable.printStackTrace();
        loading.set(false);
        error.setValue(throwable);
    }

}
