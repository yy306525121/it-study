package cn.codeyang.design.singleton;

public enum  HttpEnum {

	HTTP_200(200, "请求成功"), HTTP_500(500, "请求失败");

	HttpEnum(Integer httpCode, String httpMsg) {
		System.out.println("http初始化");
		this.httpCode = httpCode;
		this.httpMsg = httpMsg;
	}

	private Integer httpCode;
	private String httpMsg;



	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public String getHttpMsg() {
		return httpMsg;
	}

	public void setHttpMsg(String httpMsg) {
		this.httpMsg = httpMsg;
	}

	public static void main(String[] args) {
		System.out.println(HttpEnum.HTTP_200.httpCode);
		System.out.println(HttpEnum.HTTP_200.httpCode);
		System.out.println(HttpEnum.HTTP_200.httpCode);
		System.out.println(HttpEnum.HTTP_200.httpCode);
	}
}
