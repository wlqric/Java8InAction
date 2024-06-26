学习计划

1. Java Stream
2. Spring
    1. Spring基础知识：依赖注入,AOP,常用注解、包扫描逻辑
    2. 常用注解：@Component、@Service、@Repository、@ComponentScan、@Aspect（AOP相关）、@Autowired、@Resource
3. RPC
    1. Dubbo （咱们公司是Hetu，其实就是用Dubbo写的）
    2. 注册中心：Eureka （了解什么是注册中心、为什么要用注册中心）
4. 配置中心
    1. 了解下配置中心原理
    2. 咱们团队用的是：hcconfig以及注册中心服务
5. 多线程
    1. CompletableFuture
    2. 线程池
6. MySQL
    1. 索引
    2. 锁



注：你在做迁移的过程中，看到了哪些知识点你不熟悉的，你就先熟悉了，然后再干。不要想着着急把事情干完，那样反而效果不好。



排除某些类的方法了解一下：https://www.jb51.net/program/293769zfm.htm
**maven 依赖配置**
**spring 常用注解**
这些都可以找时间找找资料，了解一下

看项目：以项目为基础，先看看项目整体结构，看看项目里面具体是怎么配置的，看不懂可以先百度搜下，了解下相关概念和使用方法。边看理论边看实践效率会比较高

先尝试自己想办法解决(比如百度，~~公司ata等~~)，自己从0到1找到解决办法的话，印象会最深刻。遇到卡点的问题，可以及时找我或者其他师兄沟通，这边人都挺好，不用有啥顾忌

百度上面大部分问题都能找到，不过搜出来的不一定是正确答案，需要自己甄别，自己试一下



联调通过再提测，用例评审是在正式测试之前



# 学习笔记

## 第一章

方法可以作为函数的值来传递

Collection——存储和访问数据

Stream——描述对数据的计算

p17 默认方法没懂。

## 第二章 **行为参数化**

例：把迭代集合的逻辑和应用于每个元素的行为区分开。

属于**策略设计模式**

## 第三章 Lambda

3.6的构造函数引用没看，3.7的Lambda和方法引用实战没看。

**函数式接口**

## 第四章 流 Stream

以声明式的方法进流水线处理集合中的元素。高级迭代器。

集合关注数据，流关注计算。

数据源，中间操作链，终端操作。

## 第五章 
介绍常用的流方法

筛选和切片：filter，distinct，limit，skip，</br>
映射：map，flatmap</br>
查找和匹配：anyMatch，allMatch，noneMatch，findFirst，findAny；返回对象Optional \<T>
规约（折叠）：将流中所有元素反复结合。

| 中间操作 |      |      |
| --------- | ---- | ---- |
| filter    |      |      |
| distinct  |      |      |
| skip      |      |      |
| limit     |      |      |
| map       |      |      |
| flatMap   |      |      |
| sorted    |      |      |
| **终端操作** |      |      |
| anyMatch |      |      |
| noneMatch |      |      |
| allMatch  |      |      |
| findAny   |      |      |
| findFirst |      |      |
| forMatch  |      |      |
| collect   |      |      |
| reduce    |      |      |
| count     |      |      |

理解为这些是流的基本方法，类似于写编程语言式的的组件
