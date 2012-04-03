package com.kyu.mail;

import java.io.File;
import java.net.URL;

import com.kyu.common.Conf;


/**
 * @FileName : MailSendHelper.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class Main {

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

		Main helper = new Main();
		MailVO mailVO = helper.makeMailInfo();
		MailSender.send(mailVO);
	}

	/**
	 * <pre>
	 * makeMailInfo
	 *
	 * <pre>
	 * @return
	 * @throws Exception
	 */
	public MailVO makeMailInfo() throws Exception {
		MailVO mailVO = new MailVO();
		mailVO.setFrom("lng1982@naver.com");
		mailVO.setRecipient("lng1982@incross.com");
		mailVO.setSubject("메일전송테스트");
		mailVO.setHtmlText("<H1>Hello</H1><img src=\"img/ok.gif\"><img src=\"img/modify.gif\">");

		URL url = this.getClass().getClassLoader().getResource("msg/mail/mail.html");
		mailVO.setHtmlUrl(url);

		URL attatchUrl = this.getClass().getClassLoader().getResource("msg/mail/img/ok.gif");
		mailVO.setAttachedFiles(new File(attatchUrl.getFile())); // 첨부 파일

		return mailVO;
	}
}
