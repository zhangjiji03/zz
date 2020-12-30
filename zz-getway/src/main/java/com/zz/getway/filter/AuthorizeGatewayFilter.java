package com.zz.getway.filter;

/**
 * 项目名称:     zz-getway
 * 类名称:       AuthorizeGatewayFilter
 * 创建时间:     2020/8/4 18:03
 * 版本:         1.0
 */
/*
@Component
public class AuthorizeGatewayFilter implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "Authorization";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AUTHORIZE_TOKEN);
        ServerHttpResponse resp = exchange.getResponse();
        if(StringUtils.isBlank(token)){
            //没有token
            return authErro(resp,"目前您没有无权限访问，请提交权限码");
        }else{
            //有token
            try {
                JwtUtil.checkToken(token,objectMapper);
                return chain.filter(exchange);
            }catch (ExpiredJwtException e){
                log.error(e.getMessage(),e);
                if(e.getMessage().contains("Allowed clock skew")){
                    return authErro(resp,"您的认证权限已过期，请重新进行认证");
                }else{
                    return authErro(resp,"认证失败");
                }
            }catch (Exception e) {
                log.error(e.getMessage(),e);
                return authErro(resp,"认证失败");
            }
        }


        return null;
    }



    @Override
    public int getOrder() {
        return 0;
    }
}
*/

