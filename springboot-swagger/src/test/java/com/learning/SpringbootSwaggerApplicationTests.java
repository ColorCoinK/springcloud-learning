package com.learning;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSwaggerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void LambdaTest() {
		String[] parentNode = {"华为莘闵区域", "中兴松江区域", "中兴浦东区域", "华为莘闵纪王区域", "中兴西区区域4期", "华为宝山区域",
				"华为核心", "华为中区区域",
				"核心节点", "中兴嘉定区域", "华为浦东区域2", "华为浦东区域", "4K核心", "中兴青浦区域", "华为奉贤区域", "烽火高东区域01",
				"华为南区区域2", "华为西区区域",
				"中兴西区区域5期", "中兴北区区域", "中兴莘闵区域", "中兴崇明区域", "中兴奉贤区域", "华为南区区域", "烽火高东区域02", "华为宝山区域",
				"中兴东区区域3期", "无上级节点",
				"中兴金山区域", "中兴核心", "中兴南汇区域", "中兴东区区域6期"};
		List<String> nodes = Arrays.asList(parentNode);

		nodes.forEach((node) -> System.err.print(node + ";\t"));
		nodes.forEach(System.out::print);
	}

}
