package com.ez.ezmonitor;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Host.class}, version = 1, exportSchema = false)
public abstract class HostDatabase extends RoomDatabase {
    public abstract HostDao hostDao();

    volatile private static HostDatabase instance = null;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static HostDatabase getInstance(final Context context) {
        if (instance != null) {
            return instance;
        } else {
            synchronized (HostDatabase.class) {
                if (instance != null) {
                    return instance;
                } else {
                    instance = build(context);
                }
            }
        }
        return instance;
    }

    private static HostDatabase build(final Context context) {
        return Room.databaseBuilder(context, HostDatabase.class, "monitor-db")
                .addCallback(testDatabasePopulateCallback)
                .build();
    }

    private static RoomDatabase.Callback testDatabasePopulateCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                HostDao hostDao = instance.hostDao();
                hostDao.deleteAll();
                Host host1 = new Host("host1", "1.1.1.1", 22, "root", "123");
                hostDao.insertAll(host1);
                Host host2 = new Host("host2", "1.1.1.2", 1234, "root", "123");
                hostDao.insertAll(host2);
            });
        }
    };
}
