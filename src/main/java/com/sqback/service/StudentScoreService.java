package com.sqback.service;

import com.sqback.utils.sqBackResult;

public interface StudentScoreService {

    //查询单条基础数据
    public sqBackResult findStudentScore(String sid) throws Exception;

}
