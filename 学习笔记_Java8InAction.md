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

属于**策略模式**

## 第三章 Lambda

3.6的构造函数引用没看。

**函数式接口**

## 第四章 流 Stream

以声明式的方法进流水线处理集合中的元素。高级迭代器。

集合关注数据，流关注计算。

数据源，中间操作链，终端操作。

## 第五章 
介绍常用的流方法，前面是对流的加工，后面是生成。当工具书看。

### 加工
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

文件流联系到NIO

（chapter5的最后多少有点囫囵吞枣了）

# 第7章 并行数据处理与性能

讲并行处理

7.1.4 高效使用并行流，并行谨慎使用，贸然使用可能效果还不如不用。

分支合并框架 并行版的分治算法。RecursiveTask。

spliterator，并行执行版的Iterator，遍历元素



# 第8章 重构、测试和调试

环绕模式？

用Lambda重构设计模式：策略模式、模板方法、观察者模式、责任链模式、工厂模式。

顺便学习了设计模式，感觉想把代码写漂亮是有用的

看到责任链模式。



# 第10章 Optional



# 第11章 CompletableFuture

|          | 实现                           | 特点                                                    |
| -------- | ------------------------------ | ------------------------------------------------------- |
| 并行处理 | 用分支/合并框架、并行流        | 一个操作 -> 多个子操作，在不同核/CPU/机器上并行执行     |
| 并发处理 | 用Future、CompetableFuture接口 | 充分利用这个CPU核（减少远程服务、查数据库等的阻塞时间） |

### 并行该选择哪个

Stream适合：计算密集型，且没有I/O；流的延迟特性让我们难以判断什么时候触发了等待。

CompletableFuture适合：并行单元有I/O或网络连接等待，根据等待/计算设定线程数。



`Future`：建模了异步计算，比`Thread`易用

CompletableFuture之于Future，如同Stream之于Collection。

异步api如何返回：要么回调函数，要么调用方再次执行一个方法（等待，直到计算完成）

要点:

为客户异步api;

CompletableFuture提供了异常管理,可以抛出/管理异步任务发生的异常;



<img src="./学习笔记_Java8InAction.assets/Snipaste_2024-07-20_11-16-45-1721445869195-2.png" alt="Snipaste_2024-07-20_11-16-45" style="zoom:50%;" />

<img src="./学习笔记_Java8InAction.assets/Snipaste_2024-07-20_11-19-04.png" alt="Snipaste_2024-07-20_11-19-04" style="zoom:50%;" />

CompletableFuture比并行流好的原因：可以配置执行器，尤其是线程池的大小。并行流不可以。

