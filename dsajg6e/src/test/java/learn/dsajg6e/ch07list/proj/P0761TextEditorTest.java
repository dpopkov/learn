package learn.dsajg6e.ch07list.proj;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0761TextEditorTest {

    @Test
    public void whenRightThenCursorIsMovedLeft() {
        P0761TextEditor text = new P0761TextEditor("ab");
        assertThat(text.toString(), is("|ab"));
        text.right();
        assertThat(text.toString(), is("a|b"));
        text.right();
        assertThat(text.toString(), is("ab|"));
        text.right();
        assertThat(text.toString(), is("ab|"));
    }

    @Test
    public void whenLeftThenCursorIsMovedLeft() {
        P0761TextEditor text = new P0761TextEditor("ab");
        assertThat(text.toString(), is("|ab"));
        text.right();
        text.right();
        assertThat(text.toString(), is("ab|"));
        text.left();
        assertThat(text.toString(), is("a|b"));
    }

    @Test
    public void canInsert() {
        P0761TextEditor text = new P0761TextEditor("ab");
        assertThat(text.toString(), is("|ab"));
        text.insert('c');
        assertThat(text.toString(), is("|cab"));
    }

    @Test
    public void canDelete() {
        P0761TextEditor text = new P0761TextEditor("ab");
        assertThat(text.toString(), is("|ab"));
        text.delete();
        assertThat(text.toString(), is("|b"));
    }
}
