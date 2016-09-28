# MyArchitecture

## 整体架构
整体采用MVP + Dagger2 +Rretrofit + RxJava <br>

## 包说明

#### 根目录
全局Application相关的内容 <br>

##### contants
本地/服务器/数据库用到的常量 <br>

#### customview
自定义View <br>

#### event
EventBus用到的事件 <br>

#### model
实体类封装

#### net.retrofit 
使用Retrofit和RxJava对网络层进行封装 <br>

###### cookies
OkHttp 中对cookie的管理 <br>

###### factory
设置Retrofit的一些参数, 然后生产service (retrofit.create), 这样所有的业务逻辑都使用BaseService即可, 不需要在每个请求都创建一个service <br>

###### https
对https的支持 <br>

###### service
封装了BaseService及通过BaseService进行网络请求的操作 <br>

###### subscriber
观察者的封装, 包括下载及普通的Http请求 <br>

#### ui
界面相关的都放这里 <br>

###### base
BaseActivity 和 BaseFragment, 为子类提供通用的操作方法 <br>

###### login
登录页面 <br>

#### utils
工具类 <br>

## BaseActivity 和 BaseFragment 
为子类提供通用的操作方法, 比如, 设置Theme/状态栏样式/初始化工作/不同状态下的控件显示 等<br>

## 网络层封装
使用通用的BaseService, 不需要为每个网络请求都创建一个单独的Service <br>
添加cookie header  https 等支持 <br>
网络请求中, 先使用map进行统一预处理, 将数据转换成业务层关心的实体类后传入substriber <br>

## 使用示例
参见login包下的具体使用 <br>
