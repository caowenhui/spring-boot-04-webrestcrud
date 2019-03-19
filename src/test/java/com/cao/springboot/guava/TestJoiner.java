package com.cao.springboot.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;

import static com.google.common.base.CharMatcher.inRange;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * @author cwh
 * @date 2019/3/19
 */
public class TestJoiner {
    private static final String[] str1 = {"Java", "Python", "js", ""};
    private static final String[] str2 = {"Java", "Python", "js", null, "C++"};
    @Test
    public void test1(){
        String joinStr = Joiner.on(",").skipNulls().join(str1);
        String joinStr2 = Joiner.on(",").skipNulls().join(str2);
        String joinStr3 = Joiner.on(",").useForNull("DEFAULT").join(str2);
        assertThat(joinStr, equalTo("Java,Python,js,"));
        assertThat(joinStr2, equalTo("Java,Python,js,C++"));
        assertThat(joinStr3, equalTo("Java,Python,js,DEFAULT,C++"));
    }

    @Test
    public void test2(){
        //omitEmptyStrings()从结果中自动忽略空字符串
        //trimResults():移除结果字符串的前导空白和尾部空白
        //trimResults(CharMatcher):给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
        //limit(int):限制拆分出的字符串数量
        List<String> list = Splitter.on(',').trimResults()
                .omitEmptyStrings().splitToList("Java,Python,,  js,C++");
        assertThat(list.size(), is(4));
        assertThat(list.get(0), equalTo("Java"));
        assertThat(list.get(1), equalTo("Python"));
        assertThat(list.get(2), equalTo("js"));
        assertThat(list.get(3), equalTo("C++"));

    }

    @Test
    public void test3(){
        List<String> strings = Splitter.fixedLength(3).omitEmptyStrings().splitToList("12312312");
        assertThat(strings.size(), is(3));
        assertThat(strings.get(2), equalTo("12"));
    }



}
