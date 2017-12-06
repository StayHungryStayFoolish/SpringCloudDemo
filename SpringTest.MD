# SpringBoot 1.5.9 简单测试

## 注解说明

**@RunWith(SpringRunner.class);** 替换掉了1.4版本的 SpringJUnit4ClassRunner

**@SpringBootTest**  该注解表明需要一个比较完整的 SpringBoot 环境，比如做集成测试。需要启动 EmbeddedWebApplicationContext 。如果只做单元测试，可以去掉。
