package com.ez.ezmonitor;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "hosts")
public class Host {

//    enum AuthMethod {
//        PASSWORD,
//        PUB-KEY;
//    }
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "host_id")
    public int id = 0;
    @ColumnInfo(name = "host_name")
    public String name;
    @ColumnInfo(name = "host_ip")
    public String ip;
    @ColumnInfo(name = "host_port")
    public int port;
    @ColumnInfo(name = "host_username")
    public String username;
    @ColumnInfo(name = "host_password")
    public String password;

    public Host(String name, String ip, int port, String username, String password) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return port == host.port && name.equals(host.name) && ip.equals(host.ip) && username.equals(host.username) && password.equals(host.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ip, port, username, password);
    }
}
