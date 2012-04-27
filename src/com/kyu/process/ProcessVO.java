package com.kyu.process;

/**
 * @FileName : ProcessVO.java
 * @Project : sample_project
 * @Date : 2012. 4. 27.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class ProcessVO {

	/** 파라미터 */
	private String param;
	/** 실행 프로그램 */
	private String execProgram;
	/** 결과 메세지 */
	private String resultMsg;
	/** 실행 결과 */
	private boolean isSuccess;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getExecProgram() {
		return execProgram;
	}

	public void setExecProgram(String execProgram) {
		this.execProgram = execProgram;
	}

	@Override
	public String toString() {
		return "ProcessVO [param=" + param + ", execProgram=" + execProgram + "]";
	}
}
