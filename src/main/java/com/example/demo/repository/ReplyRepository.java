package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Article;

@Mapper
public interface ReplyRepository {

	@Insert("""
			INSERT INTO
			reply SET
			regDate = NOW(),
			updateDate = NOW(),
			articleId = #{articleId},
			content = #{content}
			""")
	public void replyArticle(int articleId, String content);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	
	@Select("""
			SELECT *
			FROM reply
			WHERE articleid = #{articleid}
			""")
	public Article getArticle(int articleid);

}