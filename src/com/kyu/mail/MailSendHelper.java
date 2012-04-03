package com.kyu.mail;

import java.io.File;

import com.kyu.common.Conf;


/**
 * @FileName : MailSendHelper.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MailSendHelper {

	/**
	 * <pre>
	 * main
	 * 테스트
	 * <pre>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Conf.init();

		MailSendHelper helper = new MailSendHelper();
		MailVO mailVO = helper.makeMailInfo();
		MailSender.send(mailVO);
	}

	/**
	 * <pre>
	 * makeMailInfo
	 *
	 * <pre>
	 * @return
	 */
	public MailVO makeMailInfo() {
		MailVO mailVO = new MailVO();
		mailVO.setFrom("lng1982@naver.com");
		mailVO.setRecipient("lng1982@incross.com");
		mailVO.setSubject("메일전송테스트");
		mailVO.setHtmlText("<H1>Hello</H1><img src=\"cid:flower\">");

		mailVO.setAttachedFiles(new File("E:\\test\\mail\\allpopup.jpg"));
		return mailVO;
	}
}
