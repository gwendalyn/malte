malte
=====
为伟哥项目做准备。

软件安装：<br>
1. eclipse -- 官网 下载页 Eclipse IDE for Java EE Developers<br>
2. maven －－ 下载3.0.x的版本<br>
3. 打开eclipse -- Help -- Eclipse MarketPlace 搜索 Maven Integration for Eclipse 安装所有内容<br>

19-2-2014<br>
在malte-test中，创建首页 main.xhtml；<br>
在malte-m1中，创建register.xhtml, confirm.xhtml, done.xhtml及java类 UserBean;<br>
模块结构为：malte-base为基础地层jar，提供地层框架内容；<br>
malte-m1为模块类，这里为注册帐号模块，负责注册帐号页面的建设;<br>
malte-test为组装模块，它将malte-base和malte-m1一起组装成一个项目，同时提供首页；<br>
//todo <br>
暂时组装出来有重复jar包，等明天查一个插件来帮忙消除重复jar包的问题。



18-2-2014<br>
创建例子项目，包括：malte-base, malte-m1, malte-test.<br>
通过maven来进行项目组装。



