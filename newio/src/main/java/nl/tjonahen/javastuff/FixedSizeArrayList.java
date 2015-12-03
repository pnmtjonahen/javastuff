/*
 * Copyright (C) 2015 Philippe Tjon - A - Hen, philippe@tjonahen.nl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.javastuff;

import java.util.ArrayList;
import java.util.Collection;

/**
 * List with a fixed size. When the number of elements in the List exceeds the max size the first element is removed.
 *
 * @author Philippe Tjon-A-Hen
 *
 * @param <T>
 */
public class FixedSizeArrayList<T> extends ArrayList<T> {

    private static final long serialVersionUID = -5903792971625280486L;
    private int maxSize;
    private RemoveNotify<T> removeal;

    protected final int getMaxSize() {
        return maxSize;
    }

    /**
     * Constructs a FixedSizeArrayList with a given maximum size
     *
     * @param size the maximum size or number of elements this list can hold.
     */
    public FixedSizeArrayList(final int size) {
        super();
        this.maxSize = size;
    }
    /**
     * Constructs a FixedSizeArrayList with a given maximum size
     *
     * @param size the maximum size or number of elements this list can hold.
     * @param removeal the callback method to call when an element is removed from the list.
     */
    public FixedSizeArrayList(final int size, final RemoveNotify<T> removeal) {
        super();
        this.maxSize = size;
        this.removeal = removeal;
    }

    @Override
    public boolean add(final T entry) {
        super.add(entry);
        if (super.size() > maxSize) {
            T removedEntry = super.remove(0);
            if (removeal != null) {
                removeal.notify(removedEntry);
            }
        }
        return true;
    }

    @Override
    public final void add(final int index, final T element) {
        super.add(index, element);
        while (super.size() > maxSize) {
            T removedEntry = super.remove(0);
            if (removeal != null) {
                removeal.notify(removedEntry);
            }
        }
    }

    @Override
    public final boolean addAll(final Collection<? extends T> c) {
        final boolean b = super.addAll(c);
        if (b) {
            while (super.size() > maxSize) {
                T removedEntry = super.remove(0);
                if (removeal != null) {
                    removeal.notify(removedEntry);
                }
            }
        }
        return b;
    }

    @Override
    public final boolean addAll(final int index, final Collection<? extends T> c) {
        final boolean b = super.addAll(index, c);
        if (b) {
            while (super.size() > maxSize) {
                T removedEntry = super.remove(0);
                if (removeal != null) {
                    removeal.notify(removedEntry);
                }
            }
        }
        return b;
    }

    @Override
    public final void trimToSize() {
        super.trimToSize();
        maxSize = size();
    }

}
