package com.lan.library.Service;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Xiang Lan
 * Created on 2019-07-12 11:25
 */
public class BookServiceImplTest {

    @Test
    public void updateBook() {
        //创建mockito对象
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        //验证行为
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
