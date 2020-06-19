package concurrent.eight.puzzle;

import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2020/4/26 10:20
 * @Description: 搬箱子谜题的抽象
 * 我们这样定义一个谜题，它包含了一个初始位置，一个目标位置，为了确定起点
 * 与目标之间的有效移动，还包含一个规则集。规则集有两部分：计算一个清单，包含始于
 * 给定位置的合法移动；计算移动到某位置的可能结果。
 */
public interface Puzzle<P, M> {
    /**
     *
     * @return 最初的位置
     */
    P initialPosition();

    /**
     *
     * @param position
     * @return 是否是目标
     */
    boolean isGoal(P position);

    /**
     *
     * @param position
     * @return 合法的移动集合
     */
    Set<M> legalMoves(P position);

    /**
     * 移动
     * @param position
     * @param move
     * @return 移动的位置
     */
    P move(P position, M move);
}
