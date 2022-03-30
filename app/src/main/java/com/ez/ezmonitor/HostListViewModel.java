package com.ez.ezmonitor;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HostListViewModel extends AndroidViewModel {
    private HostRepository hostRepository;

    private final LiveData<List<Host>> allHosts;

    public HostListViewModel(Application application) {
        super(application);
        hostRepository = HostRepository.getInstance(application);
        allHosts = hostRepository.getAllHosts();
    }

    LiveData<List<Host>> getAllHosts() {
        return allHosts;
    }

    public void insert(Host host) {
        hostRepository.insert(host);
    }
}
