package com.kyu.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.kyu.common.Conf;



/**
 * @FileName : MailSendHelper.java
 * @Project : sample_project
 * @Date : 2012. 4. 3.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class MailHandler {


	/**
	 * <pre>
	 * send
	 *
	 * <pre>
	 * @param mailVO
	 * @return
	 */
	public boolean send(MailVO mailVO) {
		boolean sentMail = false;
		try {
			URL htmlUrl = getTemplateUrl(mailVO.getTemplatePath()); // template 경로 획득
			mailVO.setHtmlUrl(htmlUrl);

			String htmlText = readFile(htmlUrl.getFile());
			String html = getMessageMaping(mailVO.getParamMap(), htmlText); // 메일 내용
			mailVO.setHtmlText(html);

			String host = Conf.getValue("mail.host");
			String authFlag = Conf.getValue("mail.smtp.auth");
			MailSender mailSender = new MailSender(host, authFlag);
			sentMail = mailSender.sendMail(mailVO);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return sentMail;
	}


	/**
	 * <pre>
	 * getMessageMaping
	 * 문자열 맵핑 후 html 반환
	 * <pre>
	 * @param paramMap
	 * @param htmlText
	 * @return
	 */
	private String getMessageMaping(Map<String, String> paramMap, String htmlText) {
		Iterator<String> iterator = paramMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = paramMap.get(key);
			htmlText = htmlText.replace("#" + key + "#", value);
		}

		return htmlText;
	}

	/**
	 * <pre>
	 * getTemplateUrl
	 * 템플릿 경로 가져오기
	 * <pre>
	 * @param templatePath
	 * @return
	 */
	private URL getTemplateUrl(String templatePath) {
		URL url = this.getClass().getClassLoader().getResource(templatePath);
		return url;
	}

	/**
	 * <pre>
	 * readFile
	 * 파일 read
	 * <pre>
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public String readFile(String path) throws Exception {
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(new File(path)));
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {}
			}
		}
		return builder.toString();
	}
}
