### HashMap的总结

#### 1、HashMap简介

HashMap是一个散列表，它存储的内容是键值对（key-value）映射。

HashMap继承于AbastractMap，实现Map，Clone able、java.io.Serializable接口。

HashMap的实现是不同步的，这意味着它不是线程安全的。它的key、value都可以为null。此外，HashMap中的映射不是有序的。

HashMap的实例有两个参数影响性能：**”初始容量“**和 **”加载因子“**。容量是 哈希表中桶的数量，初始容量 只是哈希表在创建时的容量。加载因子 是哈希表在其容量自动增加之前可以达到的一种尺度。当哈希表中的条目数超出了加载因子乘以当前容量的乘积时，则对该哈希表进行rehash操作，从而哈希表将有两倍的容量。

HashMap默认的容量是16；增加容量时，每次将容量变为“**原始容量***2”

**使用场景**是基于“拉链法”实现的散列表。一般用于单线程程序中。

#### 2、HashMap的特点

hashMap是根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但是遍历却是不确定。HashMap最多只允许一条记录的键位null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。

#### 3、HashMap1.7和1.8区别

**jdk1.7**中HashMap底层是**数组和链表**结合在一起使用也就是 **链表散列**。HashMap通过key的hashCode经过扰动函数处理后得到hash值，然后通过（n-1）&hash判断当前元素存放的位置（这里的n指的是数组的长度），如果当前位置存在元素的话，就判断该元素与要存入的元素的hash值以及key是否相同，如果相同的话，直接覆盖，不相同就通过拉链法解决冲突。

所谓扰动函数指的就是hashMap的hash方法。使用hash方法也就是扰动函数是为了防止一些实现比较差的hashCode（）方法  换句话说就是扰动函数之后可以减少碰撞。

所谓“**拉链法**”就是：将链表和数组相结合。也就是说创建一个链表数组，数组中每一格就是一个链表。若遇到哈希冲突，则将冲突的值加到链表中即可。

![image-20200709143842724](D:\studyLife\image-02.png)

**jdk1.8**之后

相比于之前的版本，jdk1.8之后在解决哈希冲突时有了很大的变化，当链表长度大于阈值（默认是8）时，将链表转化为红黑树，以减少搜索时间。

![image-20200709144149806](D:\studyLife\image-03.png)

TreeMap、TreeSet以及jdk1.8之后的HashMap底层都用到了红黑树。红黑树就是为了解决二叉查找树的缺陷，因为二叉查找树在某些情况下会退化成一个线性结构。

##### HashMap的定义：

```Java
public class HashMap<K,V>
    extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable { ... }
```

**HashMap的遍历方法**

```java
package lian.xi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PracticeHashMap {
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("a", "@163.com");
		map.put("b", "@qq.com");
		map.put("c","@yonyou.com");
		
		System.out.println("第一种遍历方法，通过Map.keySet");
		
		for(String key : map.keySet()) {
			System.out.println("key="+key+" value="+map.get(key));
		}
		
		System.out.println("通过Map.entrySet使用iterator遍历key和value");
		Iterator<Map.Entry<String,String>> it=map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry=it.next();
			
			System.out.println("key="+entry.getKey()+" and value="+entry.getValue());
		}
		
		System.out.println("通过Map.entrySet"+ "遍历key和value");
		
		for(Map.Entry<String, String> entry :map.entrySet()) {
			System.out.println("key="+entry.getKey()+" and value= "+entry.getValue());
		}
	}

}
```

