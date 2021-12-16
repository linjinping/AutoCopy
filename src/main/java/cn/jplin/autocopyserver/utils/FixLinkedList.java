package cn.jplin.autocopyserver;

import java.util.Collection;
import java.util.LinkedList;

public class FixLinkedList extends LinkedList<String> {
    int length;

    public FixLinkedList(int length) {
        this.length = length;
    }


    @Override
    public boolean offer(String s) {
        while(super.size() >= length){
            super.poll();
        }
        return super.offer(s);
    }
}
