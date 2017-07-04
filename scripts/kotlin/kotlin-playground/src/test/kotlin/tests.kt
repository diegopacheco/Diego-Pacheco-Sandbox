import kotlin.test.assertEquals
import org.junit.Test
import com.github.diegopacheco.sandbox.kotlin.basic.Function

class TestSource {
    @Test fun f() {
        assertEquals(3, Function().sum(1,2))
    }
}
