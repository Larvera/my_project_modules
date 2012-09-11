package com.kyu.component.test.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @FileName : JsonResultVO.java
 * @Project : sample_project
 * @Date : 2012. 9. 11.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class JsonResultVO {

	private boolean isSuccess;
	private String result;
	private String msg;
	private Object info;
	private List<?> list;

	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the info
	 */
	public Object getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(Object info) {
		this.info = info;
	}

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * <pre>
	 * toJsonString
	 * json result
	 * <pre>
	 * @return
	 */
	public String toJsonString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.element("isSuccess", isSuccess);
		jsonObj.element("msg", msg);
		jsonObj.element("result", result);
		jsonObj.element("list", list);
		jsonObj.element("info", info);
		return jsonObj.toString();
	}

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		for (int i = 0; i < 5; i++) {
			json.element("key" + i, i);
		}

		Map<String, String> testMap = new HashMap<String, String>();
		testMap.put("map1", "1");
		testMap.put("map2", "2");
		testMap.put("map3", "3");

		json.element("vo", testMap);
		System.out.println(json.toString());
	}
}
