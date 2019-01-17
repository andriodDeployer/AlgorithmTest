/**
 * Created by DELL on 2018/11/8.
 *
 * 哈希表：基本上hash表的实现都是基于顺序表(数组)结构实现，主要就是利用数组结构支持随机访问的特性。
 * 通常来说哈希表通过散列函数，将key转换成数组的下标，然后将key对应的value存放到数组在该下标指定的位置。
 * 当通过key查找这个对应的value是，利用同样的散列函数，映射成数组的下标，从下标指定的位置取出之前存放的value。
 *
 * 通常散列函数的设计，在功能上需求是：
 *      1.散列函数的返回值必须为非负整数，因为散列值实质上就是数组的下标。
 *      2.key相同，散列值一定相同。否则存进去，可能就找不到，或者找到错的值。
 *      3.key不同，散列值尽量不同。这一条没有办法保证key不同，散列值一定不同，因为散列值就是数组的下标，数组大小是固定，也就是说，设计的散列函数返回值的范围是固定，重复的散列值也是难免的。
 *
 * 正是因为不同的key，散列值可能相同，那么当两个不同的key，散列值相同时，也就是他们要在数组中存放的下标是相同的，如果不做处理的话，会产生数据的覆盖。
 * 这种现象，称之为散列冲突。
 * 常用的散列冲突解决办法有两种：
 *      1.开放寻址法：当发生冲突时，那么就该这个key重新再找一个位置，知道不冲突位置。“重新再找一个位置”的方法很多：线性探测，二次探测，从新hash等。
 *          查找时以同样的冲突结果方法进行定位(数组中不光单纯存放value，还存放可以确定key的信息，要不然，冲突时，如何确定怎样算是找到了呢？)。
 *      2.链表法：使用链表法时，数组中存放的就不是value了，而是链表的节点。经过散列后，将key的value封装成节点，插入到指定的链表上
 *      当发生散列冲突时，将冲突的value封装成节点，插入到链表的尾部即可。(节点中的数据部分，存放的不光时value还有可以确定key的信息)。
 *
 *
 *   可以发现：数组的剩余空间决定了，冲突产生的几率大小。为了减少冲突，要及时对数据进行扩容。那么何时进行扩容呢？或者说扩容的条件是什么呢？
 *   负载因子：负载因子是，数据中已经存放的数据量和数据总空间的比值，这个值越大，说经剩余空间越小，产生冲突的可能性就越大。
 *   利用复杂因子，作为判定是否扩容的条件，当负载因子达到设定的阈值是，就触发扩容。这个阈值的设定的越大，触发扩容时的负载因子就会越大，产生冲突的可能性就会越大，
 *   如果阈值太小，那么可能还有很多空间可以使用的时候，就有触发了扩容，导致空间浪费，而且扩容也是很耗费性能的(不是单纯的将旧表中的数据复制到新表中那么简单，需要重新对旧表中的数据进行重新定位才可以)。
 *   那么阈值如何选择呢？这个要结合具体的场景，以及具体的冲突结果办法了。
 *
 *
 *
 * 通常在实现散列表的时候，主要关注的三个点：
 *              1.设计优良的散列函数。
 *                  在满足散列函数的基本功能前提下，好的散列函数：
 *                      1.设计的不能太复杂，否则单纯计算散列值就会很耗费性能。
 *                      2.散列值尽可能均匀的分布，主要就是减少冲突。
 *              2.冲突的解决办法。
 *                      主要的两种解决方法：开放寻址法和链表法。
 *                          开放寻址法：数据都存放在数组中，因为数组空间是连续的，可以有效的利用cpu缓存，加快查询效率，而且不包含额外的数据，如链表法中的指针数据信息。这样对序列化和反序列化都是有好的。
 *                                      但是这种方法，会增加冲突产生的可能性，而且产生冲突的后的代价很大，因为产生冲突后，重新定位的位置，会导致其他数据又产生冲突，
 *                                      为了减少冲突，转载因子的阈值不能太大，这又导致内存空间的浪费。
 *                                      通常数据量小，装载因子小的时候，适合开放寻址法。如java中的ThreadLocalMap.
 *                          链表法：因为采用链表进行数据的存储，空间利用效率高，而且针对冲突的代价不是很大，所以对装载因子的阈值要求不是很严格，装载因子可以超过1，甚至是10都可以。
 *                                 也正是链表存储结构，使其对cpu缓存不友好。而且当链表长度过长时，那么哈希表，就变成了链表了。那么查询一个数据的时间复杂度有O(1)变成了O(n)，这也是被恶意攻击的一个漏洞。(不断的向一个链表中插入数据，导致链表很长，那么进行插入，删除，查找都很耗时，在高并发的情况下，情况更严重，这就死Dos攻击)
 *                                 同时链表法相对于开放寻址法，由于存放了指针，更加浪费内存。
 *
 *                                 为了解决链表法中产生的Dos攻击，当链表长度达到一定阈值后，将链表转换成树状结构，或者跳表，来抵抗/避免Dos攻击。
 *
 *              3.动态扩容的策略。
 *                          通过设置负载因子的阈值，可以合理有效的控制扩容的频率，但是仍然无法避免扩容，当进行一次插入操作时，触发了扩容，那么执行这次插入操作就很耗时。
 *                          其实这就是“一次性扩容”的缺点，优化一次性扩容：
 *                                  为了解决一次性扩容耗时过多的情况，我们可以将扩容操作穿插在插入操作的过程中，分批完成。
                                    当装载因子触达阈值之后，我们只申请新空间，但并不将老的数据搬移到新散列表中。
 *                                  当有新数据要插入时，我们将新数据插入新散列表中，并且从老的散列表中拿出一个数据放入到新
                                    散列表。每次插入一个数据到散列表，我们都重复上面的过程。经过多次插入操作之后，老的散列
                                    表中的数据就一点一点全部搬移到新散列表中了。这样没有了集中的一次性数据搬移，插入操作就
                                    都变得很快了。
 *
 *
 *
 *
 *           通常设计一个好的哈希表，从这三方面着手，这三方面设计好了，就离一个工业级哈希表就不远了。
 *           具体可以参考java中HashMap关于这三点的实现。
 *
 *
 *
 *
 *          通常情况下，在使用链表的情况时，会同时使用哈希表。主要原因时实现链表进行任何操作，都需要先找到要操作的接节点，而查找这个节点的时间复杂度很高，
 *          为O(n),此时利用哈希表的链表法形式，可以解决查找慢到问题。
 *          在使用哈希表的时候，也会同时使用链表：主要原因使用hash表存放的数据时无序的，结合链表，让链表来存放数据，可以控制数据存放的规则顺序。
 *
 *
 *
 *
 */
package hashtable;