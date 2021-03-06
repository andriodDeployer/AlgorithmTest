/**
 * Created by DELL on 2018/10/25.
 *
 * 所谓递归：其实就是两个步骤：“递”和“归”
 *  递：就是将大问题不断分解成小问题的过程，
 *  归：将小问题的结果收集过来，并进行合并。
 *
 * 写递归的步骤：
 *  1.将大问题分解成小问题，保证大问题和小问题的求解思路是完全是相同的，
 *  2.写出递推公式。(最为关键)
 *  3.找出递的终止条件，也就是归的开始条件。
 *
 *  思考递归问题要避免人脑平铺直叙的思考方式。当遇见递归时，不要一层层的展开，否则会陷入循环的误区。
 *  举例来说：如果问题A可以分解为若干子问题B,C,D,可以设定B，C，D已经解决，重点思考的问题是如何利用子问题B，C，D的结果求解A问题的过程，
 *  这样我们只需要关系A问题和子问题B，C，D子问题两层之间的关系即可。而不是深入B，C，D，问题具体怎么解决。不要视图人脑去分解递归的每个步骤。
 *
 *  使用递归注意点：
 *      1.防止因为递归层次过多(达到终止的条件很“困难”)导致堆栈溢出。
 *      2.防止或者减少递归过程中的重复计算。导致计算效率降低，甚至计算结果出现错误。
 *          将子问题计算的结果，缓存起来，在计算的过程中，先从缓存中取，如果取不到，在进行计算。
 *
 *
 *  递归的优缺点：
 *      递归的过程就是函数不断调用的过程，为函数的调用，需要开辟很多业务逻辑之外空间，用来保存函数的线程数据到堆栈中。
 *      递归的表达能力很强，写起来也非常的简洁。
 *      将递归代码改成非递归代码：
 *          笼统的说，所有递归代码都可以改造成非递归代码实现，因为递归是借助栈来实现的，只不过这个栈是系统或者虚拟机提供的，我们无法感知罢了，
 *          如果我们在自定义的栈上来将递归逻辑改造成非递归的代码。
 *
 *      将递归转换成非递归：
 *          将递推公式展开，尽量多展开基层这样规律就比较容易发现，然后用循环将这种规律表达出来。
 *
 *
 *      尾递归：
 *          尾递归时尾优化的一种特殊形式，
 *           当调用一个方法时，需要开辟一个栈空间，用来存放该方法的局部变量信息，当在一个方法中调用另一个方法时，常规做法是重新再开辟一个空间，
 *           并在这个新的栈空间中存放被调用方法的局部变量。使用这种常规的做法，当进行递归调用时，会不断的开辟栈空间，开辟栈空间的个数，等于递归调用的深度。
 *           通常情况下，栈的大小时有限的，那么就导致递归调用的深度收到限制，当递归调用过深时，会使栈空间耗尽，产生栈溢出。
 *
 *           为了防止这种情况的发生，编译器会对一些特殊形式的方法调用进行优化。如果一个方法(fun1)的返回值，就是该方法内部，调用的方法(fun2)的返回值的话，那么
 *           执行fun2时，就不必在产生新的栈空间，而是让fun2复用fun1的栈空间，因为fun2的返回值，就是fun1的返回值，在调用fun2时，那么fun1也就没有用了，
 *           fun1栈空间的局部变量也就没有存在的必要了，所以让fun2复用fun1的栈空间也是没有问题的。
 *
 *           通常尾优化，需要编译器的支持，当支持尾优化的编译器，发现方法调用满足尾优化形式，那么就可以实现尾优化。
 *           尾优化的主要目的就是复用栈空间，来节省栈空间的开销，减少栈溢出的风险。
 *           如果编译器不支持的话，即使写法满足尾优化，也是无法进行尾优化的。
 *
 */
package recursion;