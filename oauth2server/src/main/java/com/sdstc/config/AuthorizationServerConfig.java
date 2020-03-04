package com.sdstc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private JWTTokenEnhancer jwtTokenEnhancer;

	@Autowired
	private ClientDetailsService clientDetailsServiceJdbc;

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailService;

	@Value("${oauth2.signingKey}")
	private String signingKey;

	@Value("${oauth2.accessTokenValiditySeconds}")
	private Integer accessTokenValiditySeconds;

	@Value("${oauth2.refreshTokenValiditySeconds}")
	private Integer refreshTokenValiditySeconds;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients();
		security.tokenKeyAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsServiceJdbc);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//密码模式需要
		endpoints.authenticationManager(authenticationManager);
		//refresh需要
		endpoints.userDetailsService(userDetailService);
		
		endpoints.tokenServices(defaultTokenServices());
	}

	@Bean
	public TokenStore jwtTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter;
	}

	@Primary
	@Bean
	public DefaultTokenServices defaultTokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		//设置token存储
		tokenServices.setTokenStore(jwtTokenStore());

		//设置token转换和类型
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter()));
		tokenServices.setTokenEnhancer(tokenEnhancerChain);

		tokenServices.setSupportRefreshToken(true);
		tokenServices.setClientDetailsService(clientDetailsServiceJdbc);

		// token有效期
		tokenServices.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
		// refresh_token
		tokenServices.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);
		return tokenServices;
	}

}
