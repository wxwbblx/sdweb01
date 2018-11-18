package com.wxw.sdweb.util;

import com.wxw.sdweb.Result;
import com.wxw.sdweb.enums.ResultCode;

public class ResultUtils {
	public static Result success(Object data) {
		return new Result<>(ResultCode.SUCCESS, data);
	}

	public static Result warn(ResultCode resultCode, String msg) {
		Result<Object> result = new Result<>(resultCode);
		result.setMsg(msg);
		return result;
	}

	public static Result warn(ResultCode resultCode) {
		return new Result(resultCode);
	}
}
