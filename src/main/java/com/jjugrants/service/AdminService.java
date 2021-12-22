package com.jjugrants.service;

import com.jjugrants.domain.Admin;

import java.util.Map;

public interface AdminService {
    Admin login(String account, String password);

    Map<String, Object> getCharts();

    boolean reviewDel(String id);
}
