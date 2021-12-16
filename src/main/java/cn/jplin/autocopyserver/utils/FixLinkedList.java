package cn.jplin.autocopyserver.utils;

import java.util.Collection;
import java.util.LinkedList;

public class FixLinkedList extends LinkedList<String> {
    int length;

    public FixLinkedList(int length) {
        this.length = length;
    }

    public void history(){

    }

    @Override
    public boolean offer(String s) {
        while(super.size() >= length){
            super.poll();
        }
        return super.offer(Integer.toString(s.hashCode()));
    }
}

