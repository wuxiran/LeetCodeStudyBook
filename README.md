"# LeetCodeStudyBook" 
我的leetcode刷题记录，记录自己刷leetcode的心得体会


#### 一，两数之和

##### 解法

1. 暴力法
2. 一遍哈希法：仅仅只遍历一次达到目标 solution01，也同样是放置在hashmap中
3. 两遍哈希法：简单的说就是把数组以及他的为止丢到hashMap中，target-num[i]是否会在HashMap中。solution02
##### 注意点
1. 注意，入参的检查



#### 二，两数相加：两条链表的相加
##### 解法
1. 明白什么是哑节点 dummyHead
2. 注意链表的判空
3. 注意处理进位的问题 carry 


#### 三，寻找无重复的最长子串： 例如：aasdasqweqw

##### 解法

1. 滑动窗口法

    简单的来说，就是用一个窗口来找字符，遇到相同的字符，移动窗口的最左边。
    
    相似的题目还有：num3 num30 num76 num159 num209 num239 num567 num340 num632 num727


#### 四，寻找两个有序数组的中位数，算法的时间复杂度要为 O(log(m + n))

##### 解法

1. 记住各个算法的基本的时间复杂度比如这个 O(log(m + n))。什么算法的时间复杂度是这个。


#### 八，字符串转数组

##### 解法一 

我的解法就比较蠢，用了hashmap来存储0～9  然后一次遍历，循环判断来解决，这个时候对于边界的条件处理很弱。同时还要丢进数组里面

##### 解法二

两个指针，第一个指针指向字符串的开始，第二个指针指向字符串的结束。如果不是数字，那么第二个指针肯定小于第一个指针，这样就能很方便的求出答案

        //判断溢出可以学习
     if (negative) {
                    //这里判断溢出的情况和第7题一样
                    if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8) {
                        return Integer.MIN_VALUE;
                    }
                    ret = ret * 10 - cur;
                } else {
                    if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                        return Integer.MAX_VALUE;
                    }
                    ret = ret * 10 + cur;
                }
     }           


#### 二十八,可以用KMP算法实现

1. 但是要注意一些判空条件



#### 三十，后面重写


##### 新知识

1. 当遇到重复出现的东西要加入hashmap的时候，可以通过HashMap（关键值，出现的次数），来申明HashMap
            map.put(word, map.getOrDefault(word, 0) + 1);
2. 两个循环，第一个循环，循环单词长度0-len，在循环下面新增新的循环，直到遍历整个字符串s。



#### 三十八，报数

##### 递归解决问题
