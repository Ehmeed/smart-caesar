import com.xhruba08.controller.EncryptController
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

internal class EncryptControllerTest {

    var encryptController : EncryptController = EncryptController()

    @BeforeEach
    fun setUp() {
        encryptController = EncryptController()
    }


    @Test
    @Tag("ONE")
    fun `a should encrypt to b with shift 1`() {
        encryptController.encrypt("a", 1)
        assertEquals("b", encryptController.result)
        encryptController.encrypt("a", 1)
        assertEquals("b", encryptController.result) { "better check it twice"}

    }
    val letters = listOf<String>("a", "b", "c", "d")
    @Test
     fun `some phrases`() {
        assertAll(
                "people with last name of Doe",
                letters.map { testLetter(it) }.map { { assertEquals("Doe", it) } }
        )

    }

    fun testLetter(letter: String) {

    }

}