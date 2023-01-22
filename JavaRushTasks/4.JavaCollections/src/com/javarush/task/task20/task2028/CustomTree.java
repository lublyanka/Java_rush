package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    final LinkedList<Entry<String>> linkedList = new LinkedList<>();
    Entry<String> root;
    private int size;

    public CustomTree() {
        root = new Entry<>("Eva");
        linkedList.add(root);
    }

    public String getParent(String s) {
        Integer index = getIndexOf(s);
        if (index != null)
            return linkedList.get(index).parent.elementName;
        else return null;

    }

    private Integer getIndexOf(String s) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).elementName.compareTo(s) == 0)
                return i;
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String string) {
            this.elementName = string;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public boolean hasChildren() {
            return !availableToAddLeftChildren || !availableToAddRightChildren;
        }
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry<String> current = root;
        Entry<String> newEntry = new Entry<>(s);
        newEntry.parent = current;
        linkedList.add(newEntry);
        size++;

        if (current.availableToAddLeftChildren) {
            current.availableToAddLeftChildren = false;
            current.leftChild = newEntry;

        } else {
            current.availableToAddRightChildren = false;
            current.rightChild = newEntry;
            getNewRoot(null);
        }

        return true;
    }

    private void getNewRoot(String entry) {
        if (entry == null) {
            linkedList.indexOf(root);
            boolean isChanged = false;
            while (!isChanged) {
                for (int i = linkedList.indexOf(root) + 1; i < linkedList.size(); i++) {
                    if (linkedList.get(i).isAvailableToAddChildren()) {
                        root = linkedList.get(i);
                        isChanged = true;
                        break;
                    }
                }
            }
        } else {
            int index = getIndexOf(entry);
            if (linkedList.get(index).hasChildren()) {
                root = linkedList.get(index);
                getNewRoot(null);
            } else {
                if (index + 1 <= linkedList.size() - 1)
                    root = linkedList.get(index + 1);
                else root = linkedList.get(0);
                getNewRoot(null);
            }
        }
    }

    public boolean remove(Object o) {
        if (!(o instanceof String))
            throw new UnsupportedOperationException();
        else {
            Integer indexOfObject = getIndexOf(String.valueOf(o));

            if (indexOfObject != null) {
                Entry<String> parent = linkedList.get(getIndexOf(getParent(String.valueOf(o))));
                if (!parent.availableToAddLeftChildren && parent.leftChild.elementName.compareTo(String.valueOf(o)) == 0) {
                    parent.leftChild = null;
                    parent.availableToAddLeftChildren = true;
                } else {
                    parent.rightChild = null;
                    parent.availableToAddRightChildren = true;
                }


                List<Entry<String>> indexToRemove = new ArrayList<>();
                indexToRemove.add(linkedList.get(indexOfObject));
                for (int i = 0; i < indexToRemove.size(); i++) {
                    Entry<String> stringEntry = indexToRemove.get(i);
                    Entry<String> entryToRemove = linkedList.get(getIndexOf(stringEntry.elementName));
                    if (entryToRemove.hasChildren()) {
                        if (!entryToRemove.availableToAddRightChildren) {
                            indexToRemove.add(linkedList.get(getIndexOf(stringEntry.rightChild.elementName)));
                        }
                        if (!entryToRemove.availableToAddLeftChildren) {
                            indexToRemove.add(linkedList.get(getIndexOf(stringEntry.leftChild.elementName)));
                        }
                    }
                }

                int decrementSize = indexToRemove.size();

                for (int i = 0; i < indexToRemove.size(); i++) {
                    linkedList.remove(indexToRemove.get(i));
                }
                size-=decrementSize;

                if (!linkedList.contains(root))
                    root = null;

                if (root == null) getNewRoot(parent.elementName);

            } else return false;
        }
        return true;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public CustomTree clone() {
        try {
            return (CustomTree) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}