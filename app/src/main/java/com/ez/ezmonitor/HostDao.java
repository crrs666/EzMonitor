package com.ez.ezmonitor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HostDao {
    @Query("SELECT * FROM hosts")
    LiveData<List<Host>> getAll();

    @Insert
    void insertAll(Host... hosts);

    @Query("DELETE FROM hosts")
    void deleteAll();
}
