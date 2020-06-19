package concurrent.eight.puzzle;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: Administrator
 * @Date: 2020/4/26 12:00
 * @Description:
 * 维护一个活动解决者任务的计数器，当计数器减到零时，就将结果方案设置为null
 * 就不会一直阻塞下去
 */
public class PuzzleSolver extends ConcurrentPuzzleSolver {
    private final AtomicInteger tackCount = new AtomicInteger(0);

    public PuzzleSolver(Puzzle puzzle, ExecutorService exec, ConcurrentMap seen) {
        super(puzzle, exec, seen);
    }


    class CountingSolverTask extends SolverTask {

        public CountingSolverTask(Object pos, Object move, Node prev) {
            super(pos, move, prev);
            tackCount.incrementAndGet();
        }

        @Override
        public void run() {
            try {
                super.run();
            } finally {
                if (tackCount.decrementAndGet() == 0) {
                    solution.setValue(null);
                }
            }
        }
    }

}
