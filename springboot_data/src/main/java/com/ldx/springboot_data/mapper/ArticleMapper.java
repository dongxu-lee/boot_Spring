package com.ldx.springboot_data.mapper;

import com.ldx.springboot_data.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

public interface ArticleMapper {

    public Article selectArticle(Integer id);

}
