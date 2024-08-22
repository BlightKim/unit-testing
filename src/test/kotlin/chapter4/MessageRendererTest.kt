package chapter4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MessageRendererTest {
    @Test
    fun message_renderer_uses_correct_sub_renderers() {
        var sut = MessageRenderer()

        val renderers = sut.subRenderers;
        assertEquals(3, renderers.count())
        assertTrue(renderers[0] is HeaderRenderer)
        assertTrue(renderers[1] is BodyRenderer)
        assertTrue(renderers[2] is FooterRenderer)
    }

    @Test
    fun `rendering_a_message`() {
        var sut = MessageRenderer()
        var message = Message(
            header = "h",
            body = "b",
            footer = "f"
        )

        val html = sut.render(message)

        assertEquals("<h1>h</h1><b>b</b><i>f</i>", html)
    }
}
