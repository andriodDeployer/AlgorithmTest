/**
 * Created by DELL on 2018/12/13.
 *
 * 堆是一种完全二叉树，同时满足任何一个节点的值大于等于或小于等于其左右节点。
 * 如果节点值大于等于其左右子节点的话，称这个堆为大顶堆。
 * 如果节点值小于等于其左右子节点的话，称这个堆为小顶堆。
 *
 * 因为堆是一种完全二叉树，所以用数组来存储堆是节省空间的存储方式。
 *
 * 向堆中插入一个数据，为了不破坏 堆是一个完全二叉树 形式，通常做法：将插入的数据放到二叉树的最后面，也就是数组的最后面，然后针对这个数据做自底向上的堆化操作。
 * 删除堆顶数据：为了不破环 堆使一个完全二叉树 形式，通常做法:将堆顶元素和最后一个叶子结点数组进行交换，然后最对树的最后叶子结点设置为无效(所谓的删除)，然后对堆顶 进行自上而下 的堆化操作。
 *
 * 构建堆的两种方法：
 *  1.从第二个元素开始向后，不断的将数组中的元素插入到堆中，插入操作，会伴随着自下向上的堆化(从元素开始位置，向上)。
 *  2.从最后一个非叶子结点开始向前，不断的将数组的元素进行自上向下堆化(从元素开始位置，向下)，
 *
 * 堆化的时间复杂度：
 *      1.自上而下进行堆化：时间复杂度为开始节点的高度。
 *      2.自地向下进行堆化：时间复杂度为开始节点的深度。
 *
 * 堆的应用：
 *  1.堆排序：
 *      利用堆进行排序，因为在堆中，堆顶是当前堆中所有元素的最值(大顶堆：最大值，小顶堆：最小值)，
 *      每次取出堆顶，然后让剩下的元素在进行堆化，类似于删除堆顶操作。
 *      删除堆顶的时间复杂度为O(log(n)),所以堆排序的时间复杂度为O(nlog(n))
 *      堆排序的时间复杂度十分稳定，且属于原地排序的排序算法。但是堆排序不是稳定的排序算法(相等的两个元素的相对位置，在排序前后，是否发生变化，发生变化，属于不稳定，没有变化，属于稳定)
 *
 *  2.优先级队列：
 *      通常情况下，会将堆看成一个优先级队列，因为堆采用数组作为存储结构，数组的第一个元素就是堆中元素在某个维度的最值，如果优先级的评判标准就是这个维度的话，那么刚好，这个堆就是一个优先级队列。
 *      从优先级队列中取出优先级最高的元素，就相当于取出堆顶元素。
 *
 *  3.topN
 *
 *
 *
 *  和快速排序的时间复杂度相同，同属于原地排序，而且比快速排序更加稳定。但是在工程应用中更多的使用快速排序而不是堆排序，原因主要两条：
 *      1.堆排序过程中数据访问方式没有快速排序对cpu友好，主要是堆排序在排序过程中的堆化操作，访问数据是跳着访问的，先访问i，在访问i * 2,无法利用cpu的还存优势。
 *      2.因为建堆的过程中，仅仅满足叶子结点小于等于或大于等于父节点，所以建堆过程中，可能会增加序列的逆序数，所以在整个排序过程中比较次数相对于快排更多。
 *      因为快排在排序过程中，序列的逆序数在变小。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package heap;