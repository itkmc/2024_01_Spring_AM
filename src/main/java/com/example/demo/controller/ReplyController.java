package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.ReplyService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Reply;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	@RequestMapping("/usr/article/doReply")
	@ResponseBody
	public String doWrite(HttpServletRequest req, String body) {

		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isNullOrEmpty(body)) {
			return Ut.jsHistoryBack("F-2", "내용을 입력해주세요");
		}

		ResultData<Integer> replyArticleRd = replyService.replyArticle(rq.getLoginedMemberId(), body);

		int id = (int) replyArticleRd.getData1();

		Article article = replyService.getArticle(id);

		return Ut.jsReplace(replyArticleRd.getResultCode(), replyArticleRd.getMsg(), "../article/detail?id=" + id);

	}
}
