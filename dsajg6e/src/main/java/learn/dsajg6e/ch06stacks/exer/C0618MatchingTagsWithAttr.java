package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.AttributedTagFinder;
import learn.dsajg6e.ch06stacks.MatchingTags;

/**
 * C-6.18
 * Modification of CF 6.8 {@link MatchingTags} that can match tags when an opening tga
 * may include attributes.
 */
public class C0618MatchingTagsWithAttr extends MatchingTags {
    public C0618MatchingTagsWithAttr() {
        super(AttributedTagFinder::new);
    }
}
