package org.example.temai.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




/**
 * @author: hanchaowei
 * @date 2023/10/9
 * @description:
 */
@Configuration
public class MybatisPlusConfig {

	/**
	 * 启用乐观锁
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
		mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		return mybatisPlusInterceptor;
	}
}
