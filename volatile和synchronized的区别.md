## volatile和synchronized的区别

### 1、synchronized关键字介绍

synchronized关键字提供了一种互斥机制，也就是说在同一时刻，只有一个线程访问同步资源，很多资料上面也成synchronized是一种同步锁。

- synchronized关键字提供了一种锁机制，能够确保共享变量的互斥访问，从而防止数据不一致的出现。
- synchronized关键字包括monitor enter和monitor exit两个JVM指令，它能够保证在任何时候任何线程执行到monitor enter成功之前都必须从主内存获取数据，而不是缓存中，在monitor exit运行成功之后，共享变量被更新后的值必须刷入主内存。

它修饰的对象有以下几种：

1、修饰一个代码块，被修饰的代码块称为同步代码块，其作用的范围是打括号{}括起来的代码。

```java
private final Object MUTEX=new Object();
public void sync(){
    synchronized(MUTEX){
        
    }
}
```

2、修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法。

```java
public synchronized void sync(){
    
}
```

3、修饰一个静态的方法，其作用的范围是整个静态方法，

```java
public synchronized static staticSync(){
    
}
```

4、修改一个类，其作用范围是synchronized后面括起来的部分。

```java
class ClassName {
   public void method() {
      synchronized(ClassName.class) {
         // todo
      }
   }
}
```

- synchronized关键字不能继承：对于父类中的 synchronized 修饰方法，子类在覆盖该方法时，默认情况下不是同步的，必须显示的使用 synchronized 关键字修饰才行。
- 在定义接口方法时不能使用synchronized关键字。
- 构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。

### 2、volatile关键字介绍

一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：

​	1、保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。

​	2、禁止进行指令重排序。

**volatile的原理和实现机制**

下面这段话摘自《深入理解Java虚拟机》：

“观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令”

lock前缀指令实际上相当于一个内存屏障（也成内存栅栏），内存屏障会提供3个功能：

​    	1、它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；

　	2、它会强制将对缓存的修改操作立即写入主存；

　　3、如果是写操作，它会导致其他CPU中对应的缓存行无效。

**使用volatile关键字的场景**

虽然volatile有部分synchronized关键字的语义，但是volatile不能完全代替synchronized关键字，因为volatile不具有原子性操作语义。我们在使用volatile关键字的时候也是充分利用它的可见性和有序性（防止重排序）的特点。常见的使用场景有：

1、开关控制利用可见性的特点

```Java
public class ThreadCloseable extends Thread{
    //volatile关键字保证了started线程的可见性
    private volatile boolean started=true;
    
    @Voerride
    public void run(){
        while(started){
            //to do
        }
    }
    public void shutdown(){
        this.started=false;
    }
}
```

2、标记利用顺序性特点

3、单例模式的double-check也是利用了顺序性特点

### 3、volatile和synchronized的区别

**1、使用上的区别**

- volatile关键字只能用于修饰实例变量或类变量，不能用于修饰方法以及方法参数和局部变量、常量等。
- synchronized关键字不能对变量修饰，只能用于修饰方法或者语句块。
-  volatile修饰的变量可以为null，synchronized关键字同步语句块的monitor对象不能为null、

**2、对原子的保证**

- volatile无法保证原子性
- 由于synchronized是一种排他的机制，因此被synchronized关键字修饰的同步代码块是无法被中途打断的，因此可以保证代码的原子性。

**3、对可见性的保证**

- 两者都可以保证共享资源在多线程之间的可见性，但是实现的机制不同。
- synchronized借助于JVM指令monitor enter和monitor exit对通过排他的方式使得同步代码串行化。
- volatile使用机器指令“lock”的方式迫使其他线程工作内存中的数据失效。

**4、阻塞状态**

- volatile不会使线程陷入阻塞
- synchronized关键字会使得线程进入阻塞状态