package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.ReplyService;
import com.example.demo.util.Ut;
import com.example.demo.vo.ResultData;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	@PostMapping("/usr/article/doReply")
	@ResponseBody
	public String doReply(@RequestParam("articleId") int articleId, @RequestParam("content") String content) {

		if (Ut.isNullOrEmpty(content)) {
			return Ut.jsHistoryBack("F-2", "내용을 입력해주세요");
		}

		ResultData<Integer> replyArticleRd = replyService.replyArticle(articleId, content);

		int id = replyArticleRd.getData1();

		return Ut.jsReplace(replyArticleRd.getResultCode(), replyArticleRd.getMsg(), "../article/detail?id=" + id);
	}
}
