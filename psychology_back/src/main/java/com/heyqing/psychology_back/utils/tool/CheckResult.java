package com.heyqing.psychology_back.utils.tool;

import io.jsonwebtoken.Claims;

/**
 * ClassName:CheckResult
 * Package:com.heyqing.psychology_back.utils.tool
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
public class CheckResult {
    private int errCode;

    private boolean success;

    private Claims claims;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }
}