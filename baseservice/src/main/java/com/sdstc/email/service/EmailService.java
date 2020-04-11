package com.sdstc.email.service;

import com.sdstc.email.dto.EmailDto;

public interface EmailService {
    void send(EmailDto dto);
}
