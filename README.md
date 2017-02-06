# Spring-shiro
  为了给MIS系统添加一套较为通用的权限控制功能，本项目基于Spring，整合Apache Shiro框架，实现用户管理和权限控制，主要内容如下：
  
  1.登录（带验证码）；
  
  2.加密，存储的密码不采用明文；
  
  3.session管理：使用shiro默认的session管理替代Tomcat的HttpSession；
  
  4.shiro拦截器：对静态文件（HTML/JS/CSS等）进行权限控制，无权限则请求不到；
  
  5.后台接口权限控制：对后台接口启用权限控制，对应的借口若不满足权限或角色要求，则请求失败；
  
  6.用户-角色-权限使用常规RBAC的模型，用户到角色，角色到权限均为多对多关系映射。
  
  效果图：
  ![alt text](https://github.com/shenzhanwang/Spring-shiro/blob/master/%E6%88%AA%E5%9B%BE/1.jpg)
  ![alt text](https://github.com/shenzhanwang/Spring-shiro/blob/master/%E6%88%AA%E5%9B%BE/2.png)
  ![alt text](https://github.com/shenzhanwang/Spring-shiro/blob/master/%E6%88%AA%E5%9B%BE/3.png)
  ![alt text](https://github.com/shenzhanwang/Spring-shiro/blob/master/%E6%88%AA%E5%9B%BE/4.png)
  ![alt text](https://github.com/shenzhanwang/Spring-shiro/blob/master/%E6%88%AA%E5%9B%BE/5.png)
