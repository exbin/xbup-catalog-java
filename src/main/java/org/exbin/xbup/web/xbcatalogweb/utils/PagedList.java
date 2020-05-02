/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.web.xbcatalogweb.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Abstract class for paging.
 *
 * @version 0.1.23 2014/04/04
 * @author ExBin Project (http://exbin.org)
 * @param <T> entity class
 */
public abstract class PagedList<T> implements List<T> {

    @Override
    public boolean add(T e) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public void add(int index, T element) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public void clear() {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean contains(Object o) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public int indexOf(Object o) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public Iterator<T> iterator() {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public T remove(int index) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean remove(Object o) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public T set(int index, T element) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public Object[] toArray() {
        throw new RuntimeException("Operation not allowed");
    }

    @Override
    public <TT> TT[] toArray(TT[] a) {
        throw new RuntimeException("Operation not allowed");
    }
}
