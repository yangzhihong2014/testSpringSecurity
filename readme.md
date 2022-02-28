<p>spring security 注意:</p>
<p>spring security需要实现或是继承的接口：</p>

`WebSecurityConfigurerAdapter`  webSecurity配置类</br>
`GrantedAuthority`  实现通过权限控制时需要实现的接口</br>
`UserDetails`   model接口</br>
`UserDetailsService`    model的service，主要是实现`loadUserByUsername` 方法</br>

继承WebSecurityConfigurerAdapter 并重写相关方法：</br>
protected void configure(HttpSecurity http) throws Exception 
方法是允许静态资源可以安全访问，但api接口请求等都需要通过鉴权</br>

protected void configure(AuthenticationManagerBuilder auth)则是注入自定义的UserDetailsService，来实现通过权限还是通过角色控制访问

加上注解</br>
`@EnableWebSecurity`</br>
`@Configuration`</br>
`@EnableGlobalMethodSecurity(prePostEnabled = true)`
才能启动安全配置，以及启动方法安全、即可以在方法上面鉴权

通过`@PreAuthorize("hasAnyRole('ROLE_super')")` 或是`@PreAuthorize("hasAuthority('level1')")` 可以实现方法上通过角色还是权限鉴权。
注解也可以置于类上。</br>
需注意的一点是 `hasRole` 表达式认为每个角色名字前都有一个前缀 `'ROLE_'`数据库中存储的也是 `ROLE_super`

-</br>
通过thymeleaf 与spring security 结合实现的页面的权限控制，什么角色可以看见什么样的数据</br>
通过导入的命名空间：`xmlns:sec="http://www.w3.org/1999/xhtml"` </br>
</br>以及方法：`sec:authorize="hasAnyRole('ROLE_super','ROLE_normal')"`</br>
-</br>
spring security 的配置代码中指定了登录页、首页不需要权限即可访问</br>
指明了登录页，以及登录页面提交时请求的登陆接口</br>
以及退出登录时候默认返回到首页</br>
同时
`http.formLogin()
.usernameParameter("user")
.passwordParameter("pwd")` 中的参数的则是规定了页面登陆表单提交时用户名以及密码name参数
