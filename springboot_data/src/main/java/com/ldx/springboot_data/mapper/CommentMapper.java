package com.ldx.springboot_data.mapper;

import com.ldx.springboot_data.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface CommentMapper {

    @Select("select * from t_comment where id = #{id}")
    public Comment findById(Integer id);

}
