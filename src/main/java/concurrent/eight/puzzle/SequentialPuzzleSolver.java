package concurrent.eight.puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2020/4/26 10:37
 * @Description:
 */
public class SequentialPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> solve() {
        P pos = puzzle.initialPosition();
        return search(new Node<P, M>(pos, null, null));
    }

    private List<M> search(Node<P, M> node) {
        if (!seen.contains(node.pos)) {
            seen.add(node.pos);
            if (puzzle.isGoal(node.pos)) {
                return node.asMoveList();
            }
            for (M move : puzzle.legalMoves(node.pos)) {
                P pos = puzzle.move(node.pos, move);
                Node<P, M> child = new Node<>(pos, move, node);
                List<M> result = search(child);
                if (result != null){
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * @Auther: Administrator
     * @Date: 2020/4/26 10:31
     * @Description:
     * node 代表一个位置，经过一系列的移动(move)后到达该位置，它又一个move引用
     * move创建了当前位置和前一个node。我们沿着node链接逐步后退，可以重新构建出
     * 到达当前位置的移动序列。
     */
    static class Node<P, M> {
        final P pos;
        final M move;
        final Node<P, M> prev;

        public Node(P pos, M move, Node<P, M> prev) {
            this.pos = pos;
            this.move = move;
            this.prev = prev;
        }

        List<M> asMoveList() {
            List<M> solution = new LinkedList<>();
            for (Node<P, M> n = this; n.move != null; n = n.prev){
                solution.add(0, n.move);
            }
            return solution;
        }
    }
}
