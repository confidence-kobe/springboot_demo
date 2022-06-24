## springBoot 小计
### 矩阵变量：
为什么需要矩阵变量，矩阵变量的优势是什么？他解决了什么，为什么使用它？


#### 案例：
>页面开发时cookie禁用了，session里面的内容怎么使用？
session.set(a,b) ---> jsessionid ---->cookie ----> 每次发请求时携带。
url 重写：/abc;jsessionid=xxxx 把cookie的值使用矩阵变量进行传递。




### 关于请求转发这件事
>使用注解@Controller将其标明为控制层组件，可以使用RestController效果相当于@Controller和@RequestBody
> 但是使用 @Controller和@RequestBody 时为啥会报错
> 
 
### springboot 的源码部分还是要学好
### 请求的几种方式的不同
* 重定向
* 转发
上面的两种方式的不同有哪些？
>thymeleaf的行内写法：[[${session.user.name}]]
### thymeleaf视图模板引擎
thymeleaf(效率较低)

* 设置属性值
```html
<input type="password" value="cwlz" th:attr="value=#{demo.s}"/>
```

#### 抽取公共的页面
