/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :java-nio
 * Package Name :com.cds.learn
 * Date Created :2016/9/12
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/9/12      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.learn;

import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpPost httpPost = new HttpPost("http://207.207.77.62/BigDataApp/irisData/updateImageData");
        EntityBuilder builder = EntityBuilder.create();
        httpPost.setEntity(new StringEntity("{\"records\":[{\"szFaceSnapTime\":1473668758000,\"dulSnapID\":100000999,\"feature\":[-1.224085,-0.69305,0.556287,0.822551,-1.603081,-0.029037,0.641162,-0.342936,0.052249,0.711672,0.127621,0.137466,-0.568265,-1.473162,1.051362,-0.851765,-0.020561,-0.021323,-2.515673,-1.675392,1.142374,0.396004,0.46442,0.660378,-0.072258,1.020687,-0.634868,-1.090254,-1.139931,0.574851,-1.398018,1.24656,1.531525,0.151971,0.428147,-1.389987,0.692163,1.063758,-0.472317,0.980983,-0.847294,0.190471,0.258415,0.251229,1.011845,-0.901726,-1.899788,1.738095,1.266913,0.823916,-0.617901,-0.786386,0.509347,1.008958,0.172435,1.596445,0.664238,0.244852,0.306722,0.154777,0.752903,2.42672,0.125888,-0.739018,-1.688396,-1.347863,-0.85083,0.462853,1.016534,-1.490072,0.830642,-1.5007,-1.339079,0.455332,-0.020939,2.823839,-0.13153,0.286072,-1.292933,1.190908,-0.525018,-2.047493,-0.114536,0.035155,-2.112978,1.347043,-0.6646,0.027973,-0.088301,1.218941,0.837657,0.747602,-0.917982,-1.063512,-0.774318,-1.084866,0.409054,-0.291898,-0.240892,0.624815,-0.421004,-1.239405,0.376751,1.093068,0.8862,0.20765,0.656465,-1.579544,1.616919,-0.606049,-0.250586,-1.68305,0.812815,0.875873,0.332107,0.528345,1.001144,0.364639,-0.513423,1.234977,0.480807,-1.247124,-0.53454,0.994593,-1.619338,0.464663,-0.078446,1.071641,2.140322,0.055287,1.018414,-1.430924,1.425441,0.084032,0.037007,-0.667712,1.068441,0.614116,0.904774,1.310413,1.664603,0.562121,-0.622333,0.494606,-0.010669,0.19538,-0.164331,1.017084,0.502769,-1.726686,-1.272294,1.482827,-0.678993,-0.747545,-0.104175,0.886922,-1.683699,0.19307,-1.241884,0.375735,0.832371,0.75304,-0.768921,0.347441,-0.642014,-1.570475,1.320347,-0.962569,-0.358535,-1.319466,-1.671348,0.602189,1.719027,-0.776687,1.269042,1.463482,-0.292922,-0.794867,-0.929883,0.258477],\"cameraID\":\"3\",\"ulAge\":7,\"ulGlasses\":7,\"ulGender\":2}]}",ContentType.APPLICATION_JSON));

        for (int i = 0; i < 1000; i++) {
            System.out.println("3");
            CloseableHttpClient httpclient = HttpClients.createDefault();
            httpclient.execute(httpPost);
            httpclient.close();
            Thread.sleep(50);
        }


    }
}
