package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ReplyRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Reply;
import com.example.demo.vo.ResultData;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;

	public ReplyService(ReplyRepository replyRepository) {
		this.replyRepository = replyRepository;
	}

	public List<Reply> getForPrintReplies(int loginedMemberId, String relTypeCode, int relId) {
		return replyRepository.getForPrintReplies(loginedMemberId, relTypeCode, relId);
	}

	public ResultData<Integer> replyArticle(int memberId, String body) {
		replyRepository.replyArticle(memberId, body);

		int id = replyRepository.getLastInsertId();

		return ResultData.from("S-1", Ut.f("%d번 글이 생성되었습니다", id), "id", id);
	}

	public Article getArticle(int id) {
		return replyRepository.getArticle(id);
	}
}
