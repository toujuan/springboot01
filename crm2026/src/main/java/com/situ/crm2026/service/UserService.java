package com.situ.crm2026.service;

import com.situ.crm2026.model.User;

public interface UserService {
    User findByPhone(String phone);
}
