import java.util.List;

class DeepWalkerATest extends DeepWalkerTestBase {
    @Override
    <T> Iterable<T> createWalker(List<List<T>> input) {
        return new DeepWalkerA<>(input);
    }
}
