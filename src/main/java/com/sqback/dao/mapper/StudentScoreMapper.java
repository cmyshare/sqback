package com.sqback.dao.mapper;

import com.sqback.dao.entity.StudentScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface StudentScoreMapper {
    //    @Select("select sid,score from studentscore where sid = #{SID};")
    //    StudentScore findStudentScore(@Param("SID") String sid);
    StudentScore findStudentScore(@Param("sid") String sid);



}
