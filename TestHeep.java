package com.github;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.zip.Adler32;

/**
 * @ClassName TestHeep
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 19:23
 * @Version 1.0
 **/
public class TestHeep implements IHeep {

    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public TestHeep() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    @Override
    public void AdjustDown(int root, int usedSize) {  //usedSize = 4
        int child = 2 * root + 1; // child = 3 === 4
        //当孩子节点>len时，说明子树已经调整完了
        while (child < usedSize) { // 4 < 5
            int tmp = this.elem[root]; //tmp = 2
            //首先判断右孩子是否存在
            if (child + 1 < usedSize && this.elem[child] < this.elem[child + 1]) { // 10<11
                ++child;
            }
            //存在时，判断左右孩子谁大
            //左孩子大，将左孩子与父节点值进行交换
            if(this.elem[child]>tmp) {
                this.elem[root] = this.elem[child];
                this.elem[child] = tmp;
                root = child;
                child = 2*root+1;
            }else {
                break;
            }
        }
    }

    @Override
    public void initHeap(int[] array) {
        this.elem = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize- 1) / 2; i >= 0; i--) {
            AdjustDown(i, this.usedSize);
        }
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    @Override
    public void AdjustUp(int child) {
        int tmp = this.elem[child];
        while (child > 0) {
            int parent = (child - 1) / 2;
            //比较子节点和父节点的值
            if (this.elem[parent] < tmp) {
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
            }
            child = parent;
        }
    }

    @Override
    public void pushHeap(int item) {
        if (isFull()) {
            //扩容2倍
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize++] = item;
        AdjustUp(this.usedSize - 1);
    }

    @Override
    public int popHeap() {
        if (this.usedSize == 0) {
            throw new UnsupportedOperationException("堆为空");
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = tmp;
        AdjustDown(0, this.usedSize--);
        return tmp;
    }

    @Override
    public int getHeapTop() {
        return this.elem[0];
    }

    @Override
    public void HeapSort() {
        for (int i = 0; i < this.usedSize; i++) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[this.usedSize - i - 1];
            this.elem[this.usedSize - i - 1] = tmp;
            AdjustDown(0, this.usedSize - i - 1);
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }
}
