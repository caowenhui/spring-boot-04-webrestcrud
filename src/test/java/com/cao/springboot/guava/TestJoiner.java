package com.cao.springboot.guava;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static com.google.common.base.CharMatcher.inRange;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * @author cwh
 * @date 2019/3/19
 */
public class TestJoiner {
    @Test
    public void test1(){
        CharMatcher matcher = inRange('a', 'z').or(inRange('A', 'Z'));
        assertThat("aaa", equalTo("aaa"));
    }

}
