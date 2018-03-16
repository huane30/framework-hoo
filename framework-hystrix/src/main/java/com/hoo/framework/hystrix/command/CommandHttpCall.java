package com.hoo.framework.hystrix.command;

import com.netflix.hystrix.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ravihoo on 10/03/2018.
 */
public class CommandHttpCall extends HystrixCommand<String> {

    private final static String HYSTRIX_COMMAND_HTTP ="hystrix.command.http";

    private final String url;

    private final String params;


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CommandHttpCall.class);

    public CommandHttpCall(String url) {
        this(url,null);
    }

    public CommandHttpCall(String url,String params) {
        super(
                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HYSTRIX_COMMAND_HTTP))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(HYSTRIX_COMMAND_HTTP))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(HYSTRIX_COMMAND_HTTP))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerRequestVolumeThreshold(2)
                                        .withCircuitBreakerSleepWindowInMilliseconds(60 * 1000).
                                        withFallbackEnabled(true).
                                        withExecutionIsolationThreadInterruptOnTimeout(true).withExecutionTimeoutInMilliseconds(5000)));
        this.url = url;
        this.params = params;
    }

    @Override
    protected String run() throws Exception {
        logger.info("Execution of Command: url={}", url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try(CloseableHttpResponse response = httpclient.execute(httpGet)) {
            HttpEntity entity = (HttpEntity) response.getEntity();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
            String total = "";
            String line = bufferedReader.readLine();
            while (line != null){
                total += line;
                line = bufferedReader.readLine();
            }
            return total;
        }
    }

    @Override
    protected String getFallback() {
        return "failbackFor" + url;
    }

}
