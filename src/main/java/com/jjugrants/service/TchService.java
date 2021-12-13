package com.jjugrants.service;

import com.jjugrants.domain.Teacher;

public interface TchService {
    Teacher login(String workId, String password);
}
