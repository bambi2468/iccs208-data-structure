import java.util.List;

class DeepWalkerBTest extends DeepWalkerTestBase {
    @Override
    <T> Iterable<T> createWalker(List<List<T>> input) {
        return new DeepWalkerB<>(input);
    }
}
