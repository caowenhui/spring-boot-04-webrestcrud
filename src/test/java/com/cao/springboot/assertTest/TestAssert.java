package com.cao.springboot.assertTest;

import com.cao.springboot.entities.Employee;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author cwh
 * @date 2019/3/19
 */
public class TestAssert {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void init(){
        emp1 = new Employee();
        emp1.setLastName("zhangshan");
        emp1.setId(19);
        emp2 = new Employee();
        emp2.setLastName("lisi");
        emp2.setId(22);
    }

    @Test
    public void test(){
        //数值匹配
        //测试变量是否大于指定值
        assertThat(emp1.getId(), greaterThan(10));
        //测试变量是否小于指定值
        assertThat(emp1.getId(), lessThan(50));
        //测试变量是否大于等于指定值
        assertThat(emp1.getId(), greaterThanOrEqualTo(19));
        //测试变量是否小于等于指定值
        assertThat(emp1.getId(), lessThanOrEqualTo(22));

        //测试所有条件必须成立
        assertThat(emp1.getId(), allOf(greaterThan(10), lessThan(50)));
        //测试只要有一个条件成立
        assertThat(emp1.getId(), anyOf(greaterThan(20), lessThan(100)));
        //测试无论什么条件成立(还没明白这个到底是什么意思)
        assertThat(emp1.getId(), anything());

        //测试变量值等于指定值
        assertThat(emp1.getId(), is(19));
        //测试变量不等于指定值
        assertThat(emp1.getId(), not(20));

        //字符串匹配
        String url = "http://www.baidu.com";
        //测试变量是否包含指定字符
        assertThat(url, containsString("baidu"));
        //测试变量是否已指定字符串开头
        assertThat(url, startsWith("http://"));
        //测试变量是否以指定字符串结尾
        assertThat(url, endsWith(".com"));
        //测试变量是否等于指定字符串
        assertThat(url, equalTo("http://www.baidu.com"));
        //测试变量再忽略大小写的情况下是否等于指定字符串
        assertThat(url, equalToIgnoringCase("HTTP://WWW.baidu.com"));
        //测试变量再忽略头尾任意空格的情况下是否等于指定字符串
        assertThat(url, equalToIgnoringWhiteSpace("http://www.baidu.com  "));

        //集合匹配
        List<Employee> list = ImmutableList.of(emp1, emp2);
        //测试集合中是否还有指定元素
        assertThat(list, hasItem(emp1));
        assertThat(list, hasItem(emp2));

        //Map匹配
        Map<String, Employee> map = ImmutableMap.of(emp1.getLastName(), emp1, emp2.getLastName(), emp2);
        //测试map中是否还有指定键值对
        assertThat(map, hasEntry(emp1.getLastName(), emp1));
        //测试map中是否还有指定键
        assertThat(map, hasKey(emp1.getLastName()));
        //测试map中是否还有指定值
        assertThat(map, hasValue(emp2));

    }
}
