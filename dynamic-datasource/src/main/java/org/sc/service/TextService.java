package org.sc.service;

import org.sc.mapper.TextDao;
import org.springframework.beans.factory.annotation.Autowired;

public class TextService {

    @Autowired
    private TextDao textDao;

}
