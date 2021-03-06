/**
 * Created by DELL on 2019/1/14.
 *
 * 贪心算法：是一种算法思想，并不是具体的算法，常用来知道我们设计具体的算法和编码。
 * 贪心算法的内容：
 *  1.针对一组数据，我们定义了限制值和期望值，希望从中选出几个数据，在满足限制值的情况下，期望值最大。
 *  2.每次都选择当前情况下，在对限制值同等贡献的情况下，对期望值贡献最大的数据，或者对期望值贡献相同的情况下，对限制值贡献最小(每次都选择当前最好的数据，局部最优)
 *
 *  贪心算法：每次都选择当前最优的数据，最终结果最终结果却不一定是最优的。这种情况通常是：下一次选择收到上一次选择的影响，也就是说上一次的最优选择，会导致下一次选不到最优的结果。
 *  最终导致最终的结果不是最优的。如果下一次选择不受上一次选择的影响，那么贪心算法是可以得到全局最优的结果。
 *
 *
 *
 *
 */
package thoughtofalgorithmic.greedy;


