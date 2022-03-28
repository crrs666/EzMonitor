package com.ez.ezmonitor;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HostRepository {

    private HostDao hostDao;
    private LiveData<List<Host>> allHosts;

    HostRepository(Application application) {
        HostDatabase hostDb = HostDatabase.getInstance(application);
        hostDao = hostDb.hostDao();
        allHosts = hostDao.getAll();
    }

    LiveData<List<Host>> getAllHosts() {
        return allHosts;
    }

    void insert(Host host) {
        HostDatabase.databaseWriteExecutor.execute(() -> hostDao.insertAll(host));
    }
}