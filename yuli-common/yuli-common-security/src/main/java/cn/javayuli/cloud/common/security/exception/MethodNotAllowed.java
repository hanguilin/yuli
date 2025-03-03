package cn.javayuli.cloud.common.security.exception;

import cn.javayuli.cloud.common.security.exception.handler.YuLiAuthExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * 方法不允许异常
 *
 * @author hanguilin
 */
@JsonSerialize(using = YuLiAuthExceptionSerializer.class)
public class MethodNotAllowed extends YuLiOAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
