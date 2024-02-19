package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Article;
import com.example.demo.vo.Reply;

@Mapper
public interface ReplyRepository {

	@Select("""
				SELECT R.*, M.nickname AS extra__writer
				FROM reply AS R
				INNER JOIN `member` AS M
				ON R.memberId = M.id
				WHERE relTypeCode = #{relTypeCode}
				AND relId = #{relId}
				ORDER BY R.id ASC;
			""")
	List<Reply> getForPrintReplies(int loginedMemberId, String relTypeCode, int relId);

	@Insert("""
			INSERT INTO
			`reply` SET
			regDate = NOW(),
			updateDate = NOW(),
			memberId = #{memberId},
			`body` = #{body}
			""")
	public void replyArticle(int memberId, String body);

	@Select("""
			SELECT *
			FROM reply
			WHERE id = #{id}
			""")
	public Article getArticle(int id);

	@Select("SELECT LAST_INSERT_ID()")
	int getLastInsertId();

}