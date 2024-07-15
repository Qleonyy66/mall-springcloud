package com.hmall.gateway.filters;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GatewayFilter, Ordered {
    /**
     * 处理请求并将其传递给下一个过滤器
     * @param exchange 当前请求的上下文，其中包含request、response等各种数据
     * @param chain 过滤器链，基于它向下传递请求
     * @return 根据返回值标记当前请求是否被完成或拦截，chain.filter(exchange)就放行了。
     */
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        System.out.println("headers = " + headers);

        return  chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
