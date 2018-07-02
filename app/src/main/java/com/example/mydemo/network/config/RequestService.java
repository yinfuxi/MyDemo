package com.example.mydemo.network.config;

import com.example.mydemo.bean.MattersBeanInfo;
import com.example.mydemo.network.bean.BaseBean;
import com.example.mydemo.network.config.HttpConstant;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by user on 2018/4/19.
 * <p>
 * API接口
 */

public interface RequestService {

    /**
     * 获取定期产品列表
     *
     * @return
     */
    @FormUrlEncoded   // utf-8 格式
    @POST(HttpConstant.PRO_REGULAR_LIST)
    Observable<BaseBean<MattersBeanInfo>> getProRegularList(@FieldMap(encoded = true) Map<String, String> params);
}
