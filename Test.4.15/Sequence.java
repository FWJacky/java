import java.util.Arrays;

/**
 * @ClassName Sequence
 * @Description TODO
 * @Author L
 * @Date 2019/4/15 20:04
 * @Version 1.0
 **/
public class Sequence implements ISequence {

    private Object[] elem;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public Sequence() {
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    //是否为满的顺序表
    public boolean isFull() {
        if(this.usedSize==this.elem.length) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(int pos, Object data) {
        //1、pos的合法性    2、是否为满的顺序表
        if(pos <0 || pos >this.usedSize) {
            return false;
        }
        if(isFull()) {
            //让数组扩大为原来长度的两倍
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        return true;
    }

    //判断顺序表是否为空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    @Override
    public int search(Object key) {
        if(key == null) {
            return -1;
        }
        if(isEmpty()) {
            throw new UnsupportedOperationException("顺序表为空");
        }
        for (int i = 0; i <this.usedSize ; i++) {
            //key是Object,是引用类型，比较不能用"=="，要用equals方法
            if(this.elem[i].equals(key)) {
                return i;
            }
        }
        //找不到返回-1
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(key == null) {
            return false;
        }
        if(isEmpty()) {
            throw new UnsupportedOperationException("顺序表为空");
        }
        for (int i = 0; i <this.usedSize ; i++) {
            //key是Object,是引用类型，比较不能用"=="，要用equals方法
            if(this.elem[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos<0 || pos>=this.usedSize || isEmpty()) {
            return null;
        }
        return this.elem[pos];
    }

    //删除之前，保存需要删除的值作为返回值
    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index == -1) {
            return null;
        }
        //将需要删除的值保存下来
        Object oldData = this.elem[index];
        int i = 0;
        for (i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.elem[i+1] = null;
        this.usedSize--;
        return oldData;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
        this.usedSize = 0;
    }
}
