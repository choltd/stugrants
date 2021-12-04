package com.jjugrants.service;

import com.jjugrants.domain.Student;

public interface StuService {
    Student login(String userName, String password);
}
