package com.kyu.mail;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.kyu.common.Conf;

/**
 * @FileName : Main.java
 * @Project : sample_project
 * @Date : 2012. 4. 4.
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

		Main main = new Main();
		MailHandler handler = new MailHandler();
		MailVO mailVO = main.makeMailInfo();
		handler.send(mailVO);
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
		mailVO.setTemplatePath("msg/mail/test.mail");

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("name", "이남규");
		mailVO.setParamMap(paramMap);

		URL attatchUrl = this.getClass().getClassLoader().getResource("msg/mail/img/ok.gif");
		mailVO.setAttachedFiles(new File(attatchUrl.getFile())); // 첨부 파일

		return mailVO;
	}
}
