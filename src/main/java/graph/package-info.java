/**
 * Created by DELL on 2018/12/14.
 *
 *
 * 图：是一种非线性关系的数据结构。是相对于树的一种更加复杂的数据结构，
 * 在图中的几个概念：
 *      顶点和边，边的作用是建立两个顶点之间关系。
 *      方向：是边的一个属性，标识一个边是否有方向的概念，当业务中，需要图中的顶点之间有起点和终点的概念时，那么就需要边有方向的概念了，方向就是从起点执行终点。
 *      如果边有方向的概念的话，那么此时的图就是有向图，如果没有方向的概念的话，那么图就是无向图。
 *      度：度是顶点的一个属性，就是连接到顶点上的边的个数。
 *          度在有向图中又分为入度和出度，顶点的入度：把该顶点作为终点的边的个数。
 *                                     顶点的出度：把该顶点作为起点的边的个数。
 *          在无向图中，度没有出度和入度之分，也可以看成每个顶点的出度和入度是相同的。
 *      权：权是边的一个属性，标识这个边的权值。
 *
 * 图的存储：
 *      邻接矩阵：用一个二维数组datas，两个维度的元素个数是相同的，都是顶点个数，元素的值，标识两个顶点之间的关系。
 *          如果从顶点i到顶点j之间有边话，那么就对datas[i][j]赋值1，否则赋值0.对于带权的图来说，datas[i][j]赋值为权值。
 *          根据邻接矩阵的定义，邻接矩阵中的内容就是是边的信息，而邻接矩阵占用的空间是顶点个数的平方。
 *          对于顶点多，然而顶点之间边比较少的情况，使用邻接矩阵相对来说是很浪费空间的。
 *          而且对于顶点多，边少的图，称之为稀疏图。
 *
 *
 *      邻接表：邻接表是一种类似于使用拉链法解决冲突的哈希表，使用一个数组存放各个顶点的信息和一个指向链表头的指针，链表中存放的是，顶点指向的顶点，
 *             所以该链表的长度，为该顶点的出度。
 *             使用邻接表很节省空间，可以解决邻接矩阵空间浪费的问题，
 *
 *    邻接表和邻接矩阵的对比：
 *      1.空间利用率上：邻接表节省空间,空间复杂度为O(E)(E表示边的个数，如果是无向图的话，链表中节点个数为2E，对于有向图，节点个数为E)，邻接矩阵在稀疏图的存储上浪费空间，空间复杂度为O(n^2)。
 *      2.查询两个顶点关系效率：邻接表需要遍历链表时间复杂度为O(n)，邻接矩阵支持随机访问时间复杂度为O(1).
 *
 *
 *      邻接表是时间换空间的一个应用，邻接矩阵是空间换时间的一个应用。
 *      为了解决邻接表查询时间复杂度为O(n)的问题，可以将邻接表中的链表改造成：跳表，平衡树，有序数组(二分查找)等结构，
 *    所以在工程应用中对于图的存储通常都是采用邻接表。
 *
 *
 *
 *    图上操作：
 *      对图中顶点的搜索：深度优先和广度优先。
 *      广度优先和深度优先都是在图上执行的一种暴力搜索的算法，也就是遍历整个图的方式，这两种的搜索方式都适用于图规模比较小的情况。
 *      广度优先是一种按层次向外扩展的算法，在无权图中，可以利用这个算法找出从开始点到任何一点的最短距离。通常采用队列作为辅助结构，
 *      空间复杂度为O(V),时间复杂度为O(E)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
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
package graph;