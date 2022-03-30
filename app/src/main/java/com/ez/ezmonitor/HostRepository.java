package com.ez.ezmonitor;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HostRepository {
    private static HostRepository instance = null;

    private HostDao hostDao;
    private LiveData<List<Host>> allHosts;

    private HostRepository(Application application) {
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

    public static HostRepository getInstance(Application application) {
        if (instance != null) {
            return instance;
        } else {
            synchronized (HostRepository.class) {
                if (instance != null) {
                    return instance;
                } else {
                    instance = new HostRepository(application);
                }
            }
        }
        return instance;
    }
}