# photo-ssm-version1.0
SSM项目个人相册第一版
## 前端技术
- Vue 
- Axios
- layer
## 后端技术
- SSM框架
- thymeleaf
## 环境
- JDK8
- Tomcat8.5
- Maven3.8
## 数据库
- MYSQL8.0
- jdbc
- druid数据源

## 功能介绍
### 主页
- 主页显示你的照片 前5张
- 导航包括
  - 登陆
  - 注册
  - 个人相册
    - 个人相册需要登录才可以查看，否则只可以查看5张
    - 查看所有相册名称（×）
    - 根据相册名称查看对应的相片
    #### 个人相册（目前照片墙 未完善）
    ![个人相册](http://pic.yupoo.com/wang123k/c49bb738/086c9957.png)
  - 注册
    - 没有账号，需要注册，正则匹配，及Valid全校校验
    - 还没完善
  - 关于
    - 还没完善
  - 文章
    - 待开发 
#### 主页目前图片
![目前主页图片](http://pic.yupoo.com/wang123k/94abd24f/7641e6e9.png)

### 登录页
- css + js + vue + html5
- 输入 用户名 和 密码 和 验证码
- 验证码通过js实现
- thymeleaf + axios + vue
- 异步响应数据
#### 登录页图片
![登录页图片](http://pic.yupoo.com/wang123k/6d2477c1/82ee2914.png)
