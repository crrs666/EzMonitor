package com.ez.ezmonitor;


public class Host {

//    enum AuthMethod {
//        PASSWORD,
//        PUB-KEY;
//    }
    private String name;
    private String ip;
    private int port;
    private String username;
    private String password;

    public Host(String name, String ip, int port, String username, String password){
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
