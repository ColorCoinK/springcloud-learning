package com.lerning.client;

import com.lerning.client.BookFeignClient.BookFeignClientFallbackFactory;
import com.lerning.entity.Book;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Title null.java$
 * @ClassName BookFeignClient
 * @Description 获取造成fallback的原因, 同时实现服务降级
 * @Author sanss
 * @Date 2019/2/15 9:50
 * @Version 1.0
 */
@FeignClient(name = "microsevice-provider-user",fallbackFactory = BookFeignClientFallbackFactory.class)
public interface BookFeignClient {


	@GetMapping("/{id}")
	Book queryBookInfoById(@PathVariable("id") Long id);


	/**
	 * @Title
	 * @Description 获得造成fallback的原因
	 * @return
	 **/
	@Component
	@Slf4j
	class BookFeignClientFallbackFactory implements FallbackFactory<BookFeignClient> {

		@Override
		public BookFeignClient create(Throwable cause) {
			return new BookFeignClient() {
				@Override
				public Book queryBookInfoById(Long id) {
					log.error("进入回退逻辑", cause);
					return new Book(id, "领域驱动设计", 89.99);
				}
			};
		}
	}
}