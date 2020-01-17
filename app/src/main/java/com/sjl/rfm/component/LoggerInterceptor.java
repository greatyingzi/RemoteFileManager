/*
 * Copyright 2018 Zhenjie Yan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sjl.rfm.component;

import com.yanzhenjie.andserver.annotation.Interceptor;
import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpMethod;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.sjl.rfm.util.JsonUtils;
import com.sjl.rfm.util.Logger;
import com.yanzhenjie.andserver.util.MultiValueMap;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * 日志拦截器
 */
@Interceptor
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean onIntercept(@NonNull HttpRequest request, @NonNull HttpResponse response,
        @NonNull RequestHandler handler) {
        String path = request.getPath();
        List<String> headerNames = response.getHeaderNames();
        HttpMethod method = request.getMethod();
        MultiValueMap<String, String> valueMap = request.getParameter();
        Logger.i("Path: " + path);
        Logger.i("Method: " + method.value());
        Logger.i("Param: " + JsonUtils.toJsonString(valueMap));
        Logger.i("response HeaderNames: " + headerNames);
        return false;
    }
}